package com.ss.android.lark.widget.photopicker.utils;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.entity.PhotoDirectory;
import com.ss.android.lark.widget.photopicker.filter.LocalMediaSettings;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.vesdk.VEUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f447662a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f447663b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f447664c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f447665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f447666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f447667f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f447668g = null;

    public static class a implements Callable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f447669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Cursor> f447670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f447671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f447672d;

        @Override // java.util.concurrent.Callable
        public Object call() {
            long r100 = System.currentTimeMillis() - j.f447666e;
            Cursor r101 = this.f447670b.get();
            int r110 = r101.getCount();
            String r111 = "MediaStoreHelper";
            if (j.f447665d == false) goto L5;
            Log.i("MediaStoreHelper", "load db finish: " + r100 + ", total count: " + r110);
        L5:
            Object r112 = new Object();
            List<PhotoDirectory> r102 = new ArrayList();
            ArrayList r113 = new ArrayList();
            if (b(r101) == true) goto L68;
            if (r110 <= 0) goto L68;
            r101.moveToFirst();     // Catch: Exception -> L63
            boolean r103 = true;
        L10:
            int r114 = r101.getInt(r101.getColumnIndexOrThrow(DBDefinition.ID));     // Catch: Exception -> L63
            String r104 = r101.getString(r101.getColumnIndexOrThrow("_data"));     // Catch: Exception -> L63
            String r105 = r101.getString(r101.getColumnIndexOrThrow("mime_type"));     // Catch: Exception -> L63
            if (com.ss.android.lark.widget.photopicker.filter.a.a(r104, r105) == true) goto L23;
            r101.getString(r101.getColumnIndexOrThrow("bucket_display_name"));     // Catch: Exception -> L63
            int r106 = r101.getInt(r101.getColumnIndexOrThrow("width"));     // Catch: Exception -> L63
            int r107 = r101.getInt(r101.getColumnIndexOrThrow("height"));     // Catch: Exception -> L63
            long r210 = r101.getLong(r101.getColumnIndexOrThrow("_size"));     // Catch: Exception -> L63
            int r108 = r101.getInt(r101.getColumnIndexOrThrow("duration"));     // Catch: Exception -> L63
            if (r108 == 0) goto L16;
        L25:
            int r211 = r106;
            int r212 = r107;
        L27:
            String r213 = r111;
            Object r214 = r112;
            Photo r109 = new Photo(r114, r104, r105, r108, r211, r212, r210);     // Catch: Exception -> L61
            if (r109.getPath() != null) goto L31;
            boolean r115 = false;
        L32:
            if (r115 == true) goto L34;
        L47:
            r111 = r213;
        L75:
            if (b(r101) == true) goto L54;
            if (r101.moveToNext() == false) goto L54;
            r112 = r214;
        L54:
            long r116 = System.currentTimeMillis() - j.f447666e;
            c(r102, r113, r110, r103, r116);
            if (j.f447665d == false) goto L57;
            Log.i(r111, "all data finish: " + r116 + ", result count: " + r113.size() + ", isAlbumOptimization:" + LocalMediaSettings.getEnableOptimization());
        L57:
            j.f447665d = false;
            return r214;
        L59:
            e = e;
        L65:
            Log.e(r111, "loading media data error: " + e.getMessage());
            return r214;
        L34:
            if (a(r109) == false) goto L47;
            r109.durationFormat = com.larksuite.framework.utils.e.g(r108);     // Catch: Exception -> L61
            r109.isAnimatedImage = com.ss.android.lark.widget.utils.d.b(r104, r105);     // Catch: Exception -> L61
            j.a(r104, r102).getPhotos().add(r109);     // Catch: Exception -> L61
            r113.add(r109);     // Catch: Exception -> L61
            if (r113.size() != 100) goto L47;
            if (r110 <= 300) goto L47;
            long r117 = System.currentTimeMillis() - j.f447666e;     // Catch: Exception -> L61
            c(new ArrayList(r102), new ArrayList(r113), r110, r103, r117);     // Catch: Exception -> L61
            if (j.f447665d == false) goto L45;
            r111 = r213;
            Log.i(r111, "first page finish: " + r117);     // Catch: Exception -> L59
        L46:
            r103 = false;
            goto L75
        L45:
            r111 = r213;
            goto L46
        L31:
            r115 = true;
        L61:
            e = e;
            r111 = r213;
            goto L65
        L16:
            if (TextUtils.isEmpty(r105) == true) goto L25;
            if (r105.startsWith("video") == false) goto L25;
            if (TextUtils.isEmpty(r104) == true) goto L25;
            if (VideoTools.isUnsupportedVideo(r104) == true) goto L23;
            Log.i(r111, "getVideoInfo, path:" + r104 + ", type:" + r105);     // Catch: Exception -> L63
            VEUtils.VEVideoFileInfo r118 = VideoTools.getVideoInfo(r104);     // Catch: Exception -> L63
            int r119 = r118.width;     // Catch: Exception -> L63
            r211 = r119;
            r212 = r118.height;     // Catch: Exception -> L63
            r108 = r118.duration;     // Catch: Exception -> L63
        L23:
            r214 = r112;
        L63:
            e = e;
            r214 = r112;
        L68:
            if (this.f447671c == null) goto L70;
            UICallbackExecutor.execute(new i(this, r102));
        L70:
            return r112;
        }

        public final boolean a(Photo r100) {
            if (r100.isVideo() == true) goto L5;
            return true;
        L5:
            Uri r101 = j.f447662a;
            String r102 = FileUtils.m(r100.getPath());
            if (TextUtils.isEmpty(r102) == false) goto L8;
            boolean r103 = true;
        L9:
            boolean r104 = false;
            if (r103 == false) goto L12;
            return false;
        L12:
            String r105 = FileUtils.m(r100.getPath());
            if (TextUtils.isEmpty(r105) == true) goto L16;
            r104 = ((HashSet) j.f447668g).contains(r105.toLowerCase());
        L16:
            if (r104 == false) goto L18;
            return true;
        L18:
            Lazy<Boolean> r106 = MediaKVDiskCacheUtils.f447644a;
            Boolean r107 = MediaKVDiskCacheUtils.a.b(this.f447672d, r100.getPath());
            if (r107 != null) goto L21;
            long r108 = System.currentTimeMillis();
            boolean r109 = !VideoTools.isCannotTransCode(r100.getPath());
            Log.w("MediaStoreHelper", "check can compress time: " + (System.currentTimeMillis() - r108) + " path: " + r100.getPath());
            MediaKVDiskCacheUtils.a.c(this.f447672d, r100.getPath(), r109);
            return r109;
        L21:
            return r107.booleanValue();
        L8:
            r103 = ((HashSet) j.f447667f).contains(r102.toLowerCase());
            goto L9
        }

        public final boolean b(Cursor r100) {
            if (UIUtils.isActivityRunning(this.f447669a.get()) == true) goto L7;
            Log.e("MediaStoreHelper", "activity is not running");
            return true;
        L7:
            if (r100.isClosed() == false) goto L10;
            Log.e("MediaStoreHelper", "cursor is close");
            return true;
        L10:
            return false;
        }

        public a(Activity r100, Cursor r101, c r102) {
            this.f447672d = LarkContext.getApplication();
            this.f447669a = new WeakReference(r100);
            this.f447670b = new WeakReference(r101);
            this.f447671c = r102;
        }

        public final void c(List<PhotoDirectory> r100, List<Photo> r101, int r102, boolean r103, long r104) {
            if (j.f447665d == false) goto L9;
            int r105 = ((ArrayList) r101).size();
            int r106 = jdc.a.f498779a;
            Statistics.sendEvent("kb_album_load_dev", new JSONObject().put(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, r102).put("load_count", r105).put("is_first_page", r103).put(HiAnalyticsConstant.BI_KEY_COST_TIME, r104));     // Catch: Exception -> L7
        L7:
            e = move-exception;
            Log.e("AlbumLoadHitPoint", e.toString());
        L9:
            PhotoDirectory r107 = new PhotoDirectory();
            if (((ArrayList) r101).size() <= 0) goto L12;
            r107.setCoverPath(((Photo) ListProtector.get(r101, 0)).getPath());
            r107.setPhotos(r101);
            r107.setId(AccountType.ALL);
            r107.setName(UIUtils.getString(this.f447672d, R.string.Lark_Legacy_PickerAllImage));
            ListProtector.add(r100, 0, r107);
        L12:
            Iterator r108 = ((ArrayList) r100).iterator();
        L14:
            if (r108.hasNext() == false) goto L19;
            if (CollectionUtils.isEmpty(((PhotoDirectory) r108.next()).getPhotos()) == false) goto L14;
            r108.remove();
            goto L14
        L19:
            if (this.f447671c == null) goto L29;
            UICallbackExecutor.execute(new i(this, r100));
            return;
        }
    }

    public static class b implements LoaderManager.LoaderCallbacks<Cursor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f447673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f447674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f447675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Future<Object> f447676d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ExecutorService f447677e;

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final void onLoaderReset(Loader<Cursor> r100) {
            Log.i("MediaStoreHelper", "onLoaderReset");
            Future<Object> r101 = this.f447676d;
            if (r101 == null) goto L6;
            r101.cancel(true);
            this.f447676d = null;
            return;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final Loader<Cursor> onCreateLoader(int r110, Bundle r111) {
            boolean r112 = r111.getBoolean("SHOW_GIF", false);
            boolean r113 = r111.getBoolean("SHOW_VIDEO", false);
            Context r100 = this.f447674b;
            if (r113 == false) goto L13;
            StringBuilder r114 = new StringBuilder("((duration is NULL) OR ");
            Locale r101 = Locale.CHINA;
            Object[] r102 = new Object[3];
            r102[0] = Long.valueOf(Math.max(0, 0));
            String r103 = "";
            if (Math.max(0, 0) != 0) goto L7;
            String r104 = "";
        L8:
            r102[1] = r104;
            r102[2] = Long.MAX_VALUE;
            r114.append(String.format(r101, "(%d <%s duration and duration <= %d)", r102));
            r114.append(")");
            String r115 = r114.toString();
            StringBuilder r105 = new StringBuilder("(media_type=?");
            if (r112 == true) goto L12;
            r103 = " AND mime_type!='image/gif'";
        L12:
            r105.append(r103);
            r105.append(" OR media_type=? AND ");
            r105.append(r115);
            r105.append(") AND _size>0");
            return new CursorLoader(r100, j.f447662a, j.f447663b, r105.toString(), j.f447664c, "_id DESC");
        L7:
            r104 = ContainerUtils.KEY_VALUE_DELIMITER;
            goto L8
        L13:
            String[] r106 = {String.valueOf(1)};
            Uri r107 = j.f447662a;
            String[] r108 = j.f447663b;
            if (r112 == false) goto L16;
            String r116 = "media_type=? AND _size>0";
        L18:
            return new CursorLoader(r100, r107, r108, r116, r106, "_id DESC");
        L16:
            r116 = "media_type=? AND _size>0 AND mime_type!='image/gif'";
            goto L18
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final void onLoadFinished(Loader<Cursor> r100, Cursor r101) {
            Cursor r102 = r101;
            if (r102 == null) goto L18;
            Activity r103 = this.f447673a.get();
            if (r103 != null) goto L8;
            return;
        L8:
            if (this.f447675c == null) goto L17;
            ExecutorService r104 = this.f447677e;
            if (r104 != null) goto L12;
        L13:
            this.f447677e = PThreadExecutorsUtils.newSingleThreadExecutor(new com.larksuite.framework.thread.n("photo_loader"));
        L14:
            this.f447676d = this.f447677e.submit(new a(r103, r102, this.f447675c));
            return;
        L12:
            if (r104.isShutdown() == false) goto L14;
        L17:
            return;
        }

        public b(FragmentActivity r100, LarkPhotoPickerView.f r101, ExecutorService r102) {
            this.f447673a = new WeakReference(r100);
            this.f447674b = r100.getApplicationContext();
            this.f447675c = r101;
            this.f447677e = r102;
        }
    }

    public interface c {
    }

    public j() {
    }

    static {
        f447662a = MediaStore.Files.getContentUri("external");
        f447663b = new String[]{DBDefinition.ID, "_data", "mime_type", "width", "height", "bucket_id", "bucket_display_name", "date_added", "_size", "duration"};
        f447664c = new String[]{String.valueOf(1), String.valueOf(3)};
        String.valueOf(1);
        f447665d = false;
        HashSet r100 = new HashSet(16);
        f447667f = r100;
        HashSet r101 = new HashSet(4);
        f447668g = r101;
        r100.add(".avi");
        r100.add(".wmv");
        r100.add(".mpeg");
        r100.add(".mkv");
        r100.add(".flv");
        r100.add(".f4v");
        r100.add(".m4v");
        r100.add(".rmvb");
        r100.add(".dat");
        r100.add(".ts");
        r100.add(".mts");
        r100.add(".vob");
        r101.add(".3gp");
        r101.add(".mp4");
        r101.add(".mov");
    }

    public static PhotoDirectory a(String r100, List r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        File r103 = r102.getParentFile();
        if (r103 != null) goto L5;
        Log.w("MediaStoreHelper", "folderFile is null;  file is " + r102.getPath() + " , absPath = " + r102.getAbsolutePath());
    L5:
        ArrayList r104 = (ArrayList) r101;
        Iterator r105 = r104.iterator();
    L6:
        String r106 = "";
        if (r105.hasNext() == false) goto L14;
        PhotoDirectory r107 = (PhotoDirectory) r105.next();
        String r108 = r107.getName();
        if (r103 == null) goto L12;
        r106 = r103.getName();
    L12:
        if (r108.equals(r106) == false) goto L6;
    L19:
        return r107;
    L14:
        r107 = new PhotoDirectory();
        if (r103 != null) goto L17;
        r107.setName("");
        r107.setPath("");
    L18:
        r107.setCoverPath(r100);
        r104.add(r107);
        goto L19
    L17:
        r107.setName(r103.getName());
        r107.setPath(r103.getAbsolutePath());
        goto L18
    }
}
