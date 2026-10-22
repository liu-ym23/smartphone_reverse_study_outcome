package com.ss.android.lark.widget.photopickerimpl.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J \u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u001d\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/widget/photopickerimpl/model/PhotoDataLoaderCallback;", "Lcom/ss/android/lark/widget/photopickerimpl/model/BaseLoaderCallback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "photoDirId", "", "mediaType", "showGif", "", "cusorCallback", "Lcom/ss/android/lark/widget/photopickerimpl/model/PhotoDataLoaderCallback$ICursorCallback;", "<init>", "(Landroid/content/Context;IIZLcom/ss/android/lark/widget/photopickerimpl/model/PhotoDataLoaderCallback$ICursorCallback;)V", "mAppContext", "kotlin.jvm.PlatformType", "projection", "", "", "[Ljava/lang/String;", "onCreateLoader", "Landroidx/loader/content/Loader;", "Landroid/database/Cursor;", "id", "args", "Landroid/os/Bundle;", "onLoadFinished", "", "loader", EffectConfiguration.KEY_CURSOR, "onLoaderReset", "ICursorCallback", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoDataLoaderCallback extends BaseLoaderCallback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f447775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f447776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f447777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f447778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f447779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String[] f447780l;

    public interface a {
        void a(Cursor r100);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final void onLoaderReset(Loader<Cursor> r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final Loader<Cursor> onCreateLoader(int r100, Bundle r101) {
        int r102 = this.f447776h;
        if (r102 != 2) goto L5;
    L15:
        String r103 = b(BaseLoaderCallback.a(), this.f447777i);
        String[] r104 = this.f447772d;
    L16:
        String[] r105 = r104;
        if (this.f447775g == 4096) goto L20;
        r103 = r103 + " AND bucket_id='" + this.f447775g + '\'';
    L20:
        return new CursorLoader(this.f447779k, this.f447770b, this.f447780l, r103, r105, this.f447771c);
    L5:
        if (r102 == 3) goto L15;
        if (r102 != 1) goto L11;
        r103 = b(BaseLoaderCallback.a(), this.f447777i);
        r104 = new String[]{"3"};
        goto L16
    L11:
        if (this.f447777i == false) goto L13;
        r103 = this.f447773e;
    L14:
        r104 = new String[]{"1"};
        goto L16
    L13:
        r103 = this.f447774f;
        goto L14
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final void onLoadFinished(Loader<Cursor> r100, Cursor r101) {
        Cursor r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "loader");
        if (r102 != null) goto L5;
    L7:
        this.f447778j.a(r102);
        return;
    L5:
        if (r102.isClosed() == true) goto L7;
        r102.moveToFirst();
        goto L7
    }

    public PhotoDataLoaderCallback(FragmentActivity r110, int r111, int r112, boolean r113, c.C5422c r114) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "cusorCallback");
        this.f447775g = r111;
        this.f447776h = r112;
        this.f447777i = r113;
        this.f447778j = r114;
        this.f447779k = r110.getApplicationContext();
        this.f447780l = new String[]{DBDefinition.ID, "_data", "mime_type", "width", "height", "bucket_id", "bucket_display_name", "date_added", "_size", "duration"};
    }
}
