package com.ss.android.lark.widget.halfscreen;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.n;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.VideoImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.videosend.abtest.RawABTestExperimentController;
import com.ss.android.lark.videosend.checker.raw.VideoPreCheckRawService;
import com.ss.android.lark.videosend.pre.FilterConfig;
import com.ss.android.lark.videosend.pre.PreRawConfig;
import com.ss.android.lark.videosend.pre.VideoPreProcessSettingUtils;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.lark.widget.mark.MarkView;
import com.ss.android.lark.widget.photopicker.adapter.BaseSelectablePhotoAdapter;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.entity.PhotoDirectory;
import com.ss.android.lark.widget.photopicker.utils.j;
import com.ss.android.lark.widget.photopickernew.PhotoInsertToInputView;
import com.ss.android.lark.widget.photopickernew.storage.PhotoPartialStoragePermissionNotice;
import com.ss.android.lark.widget.photopickernew.utils.AlbumUtils;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.ss.android.lark.widget.thumb.AlbumSettingUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import jcc.k;
import jcc.l;
import jcc.m;
import jcc.o;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public class LarkPhotoPickerView extends FrameLayout {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f445883k0 = 0;
    public View A;
    public View B;
    public View C;
    public CommonRecyclerView D;
    public View E;
    public int F;
    public boolean G;
    public d H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f445884J;
    public boolean K;
    public boolean L;
    public boolean M;
    public List<Photo> N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public final ExecutorService U;
    public final b V;
    public final c W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f445885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f445886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f445887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PhotoInsertToInputView f445888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f445889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f445890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f445891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f445892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f445893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f445894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f445895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public UDCheckBox f445896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f445897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PhotoHorizontalAdapter f445898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l f445899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f445900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f445901q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f445902r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f445903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f445904t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f445905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FrameLayout f445906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PhotoPartialStoragePermissionNotice f445907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewGroup f445908x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewGroup f445909y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f445910z;

    public class PhotoHorizontalAdapter extends BaseSelectablePhotoAdapter<PhotoViewHolder> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Context f445911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Photo> f445912d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public gdc.b f445913e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public gdc.a f445914f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ LarkPhotoPickerView f445915g;

        public class PhotoViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ImageView f445916a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final MarkView f445917b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final AppCompatCheckBox f445918c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final View f445919d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final View f445920e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final MarkView f445921f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final View f445922g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final View f445923h;

            public PhotoViewHolder(PhotoHorizontalAdapter r100, View r101) {
                super(r101);
                this.f445916a = (ImageView) r101.findViewById(R.id.image_photo_preview);
                this.f445917b = (MarkView) this.itemView.findViewById(R.id.tv_image_tag);
                this.f445918c = (AppCompatCheckBox) this.itemView.findViewById(R.id.v_selected);
                this.f445919d = this.itemView.findViewById(R.id.v_selected_region);
                this.f445920e = this.itemView.findViewById(R.id.v_mask);
                this.f445921f = (MarkView) this.itemView.findViewById(R.id.tv_duration);
                this.f445922g = this.itemView.findViewById(R.id.visible_mask);
                this.f445923h = this.itemView.findViewById(R.id.v_divider_mask);
                r100.getClass();
                r100.getClass();
                r100.getClass();
                r100.getClass();
                r100.getClass();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f445912d).size();
        }

        public PhotoHorizontalAdapter(LarkPhotoPickerView r100) {
            this.f445915g = r100;
            this.f445912d = new ArrayList();
        }

        public final void B2(PhotoDirectory r110) {
            List<Photo> r111 = r110.getPhotos();
            if (r111 == null) goto L100;
            ArrayList r100 = new ArrayList(r111);
            int r101 = com.ss.android.lark.widget.utils.d.f449079a;
            FilterConfig r102 = (FilterConfig) VideoPreProcessSettingUtils.f444964d.getValue();
            int r103 = RangesKt.coerceAtMost(r102.getMediaCount(), r100.size());
            r102.getVideoCount();
            ArrayList r104 = new ArrayList();
            List r105 = r100.subList(0, r103);
            if (r105 == null) goto L27;
            ArrayList r106 = new ArrayList();
            Iterator r107 = r105.iterator();
        L8:
            if (r107.hasNext() == false) goto L17;
            Object r108 = r107.next();
            Photo r109 = (Photo) r108;
            if (r109 != null) goto L12;
        L14:
            boolean r112 = false;
        L15:
            if (r112 == false) goto L8;
            r106.add(r108);
            goto L8
        L12:
            if (r109.isVideo() != true) goto L14;
            r112 = true;
            goto L15
        L17:
            Iterator r113 = r106.iterator();
        L19:
            if (r113.hasNext() == false) goto L27;
            Photo r114 = (Photo) r113.next();
            if (r114 == null) goto L19;
            String r115 = r114.getPath();
            if (r115 == null) goto L19;
            if (VideoTools.getOriginLastModifyDiff(r115) > r102.getInterval()) goto L19;
            r104.add(r115);
        L27:
            Log.i("PhotoPickerUtils", "filterVideos:" + r104.size());
            if ((!r104.isEmpty()) == false) goto L68;
            com.ss.android.lark.widget.utils.c r116 = new com.ss.android.lark.widget.utils.c(r104);
            PreRawConfig r117 = VideoPreCheckRawService.f444862a;
            Intrinsics.checkNotNullParameter(r104, "mediaPaths");
            Log.i("VideoPreCheckRawService", "check");
            PreRawConfig r118 = VideoPreCheckRawService.f444862a;
            if (r118.getEnable() == 1) goto L33;
            Log.e("VideoPreCheckRawService", "remote close");
        L51:
            boolean r119 = true;
        L52:
            if (r119 == false) goto L54;
            Log.i("VideoPreCheckRawService", "onFinish");
            new Handler(Looper.getMainLooper()).post(new com.ss.android.lark.videosend.checker.raw.d(r116));
            goto L68
        L54:
            List r120 = r104.subList(0, RangesKt.coerceAtMost(r104.size(), r118.getTps()));
            ArrayList r121 = new ArrayList();
            Iterator r122 = r120.iterator();
        L56:
            if (r122.hasNext() == false) goto L67;
            Object r123 = r122.next();
            String r124 = (String) r123;
            if (FileUtils.r(r124) == true) goto L60;
        L64:
            boolean r125 = false;
        L65:
            if (r125 == false) goto L56;
            r121.add(r123);
            goto L56
        L60:
            if (VideoPreCheckRawService.f444863b.containsKey(r124) == true) goto L64;
            if (((KVRepo) VideoPreCheckRawService.f444864c.getValue()).a(r124, Integer.TYPE) == true) goto L64;
            r125 = true;
            goto L65
        L67:
            Log.i("VideoPreCheckRawService", "filter, source size:" + r104.size() + ", result size:" + r121.size());
            VideoPreCheckRawService.f444865d.addAll(r121);
            VideoPreCheckRawService.a(r116);
            goto L68
        L33:
            if (((Boolean) RawABTestExperimentController.f444841a.getValue()).booleanValue() == true) goto L36;
            Log.e("VideoPreCheckRawService", "ab test value is close");
            goto L51
        L36:
            if ((!VideoPreCheckRawService.f444865d.isEmpty()) == false) goto L38;
        L50:
            Log.e("VideoPreCheckRawService", "checkingPaths isNotEmpty or mediaPaths isEmpty");
            goto L51
        L38:
            if (r104.isEmpty() == true) goto L50;
            if (((int) CpuCallbackManager.a().f432362c) <= r118.getCpuLimit()) goto L43;
            Log.e("VideoPreCheckRawService", "cpu is to busy");
            goto L51
        L43:
            int r126 = com.ss.android.lark.videosend.compress.d.f444936d;
            if (com.ss.android.lark.videosend.compress.d.b.f444940a.f444937a.size() != 0) goto L46;
            boolean r127 = true;
        L47:
            if (r127 == true) goto L49;
            Log.e("VideoPreCheckRawService", "has media is compressing");
            goto L51
        L49:
            r119 = false;
            goto L52
        L46:
            r127 = false;
        L68:
            ((ArrayList) this.f445912d).clear();
            ((ArrayList) this.f445912d).addAll(r111);
            Iterator r128 = ((ArrayList) this.f447457b).iterator();
        L70:
            if (r128.hasNext() == false) goto L74;
            if (((ArrayList) this.f445912d).contains((Photo) r128.next()) == true) goto L70;
            r128.remove();
            goto L70
        L74:
            notifyDataSetChanged();
            this.f445915g.k(((ArrayList) this.f447457b).size());
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onAttachedToRecyclerView(RecyclerView r100) {
            super.onAttachedToRecyclerView(r100);
            this.f445911c = Contexts.preferActivity(r100.getContext());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            PhotoViewHolder r102 = (PhotoViewHolder) r100;
            Photo r103 = (Photo) ListProtector.get(this.f445912d, r101);
            boolean r104 = com.ss.android.lark.utils.a.a(Contexts.preferActivity(r102.f445916a.getContext()));
            Log.i("LarkPhotoPickerView", "onBindViewHolder, photo: " + r103.toString());
            boolean r105 = true;
            if (r104 == false) goto L16;
            Context r106 = this.f445911c;
            if (AlbumSettingUtils.a().getTotal() != 1) goto L7;
            int r107 = com.ss.android.lark.widget.utils.d.f449079a;
            Intrinsics.checkNotNullParameter(r103, "photo");
            com.ss.android.lark.widget.thumb.b.a r108 = new com.ss.android.lark.widget.thumb.b.a();
            r108.f448950a = Integer.valueOf(r103.getId());
            r108.f448951b = r103.getPath();
            r108.f448952c = r103.getSize();
            r108.f448953d = r103.isVideo();
            r108.f448954e = r103.isHeif();
            r108.f448955f = r103.isAnimatedImage;
            Lazy r109 = AlbumUtils.f447969a;
            r108.f448956g = ((Integer) ((Pair) r109.getValue()).getFirst()).intValue();
            r108.f448957h = ((Integer) ((Pair) r109.getValue()).getSecond()).intValue();
            com.ss.android.lark.widget.thumb.b.a(r106, r108, r102.f445916a);
            goto L16
        L7:
            String r110 = r103.getPath();
            DiskCacheStrategy r111 = DiskCacheStrategy.RESULT;
            if (r103.isAnimatedImage == false) goto L11;
            r111 = DiskCacheStrategy.NONE;
        L11:
            if (r103.isVideo() == false) goto L13;
            Object r112 = new VideoImage(r110);
            DiskCacheStrategy r113 = DiskCacheStrategy.NONE;
        L14:
            IRequestCreator r114 = ImageLoader.with(this.f445911c).load(r112).centerCrop().diskCacheStrategy(r113).dontAnimate(true);
            int r115 = com.ss.android.lark.widget.thumb.a.f448949a;
            r114.placeholder(R.drawable.kb_photo_pick_item_holder).error(R.drawable.kb_photo_pick_item_holder).listener(new i()).into(r102.f445916a);
            goto L16
        L13:
            PolarisFileWrapper r116 = new PolarisFileWrapper(r110);
            r113 = r111;
            r112 = r116;
        L16:
            if (r103.isAnimatedImage == false) goto L18;
            r102.f445917b.setVisibility(0);
        L19:
            boolean r117 = ((ArrayList) this.f447457b).contains(r103);
            if (r103.isVideo() == false) goto L22;
            r102.f445921f.setVisibility(0);
            r102.f445921f.setText(r103.durationFormat);
        L23:
            r102.f445918c.setChecked(r117);
            if (r117 == false) goto L26;
            r102.f445918c.setText(String.valueOf(((ArrayList) this.f445915g.f445898n.f447457b).indexOf(r103) + 1));
        L27:
            r102.f445916a.setSelected(r117);
            r102.f445920e.setVisibility(8);
            if (r117 == true) goto L50;
            LarkPhotoPickerView r118 = this.f445915g;
            if (r118.f445902r < r118.f445900p) goto L32;
            boolean r119 = true;
        L33:
            if (r119 == false) goto L36;
        L48:
            if (r105 == false) goto L50;
            r102.f445920e.setVisibility(0);
            goto L50
        L36:
            if (r118.Q == true) goto L39;
        L45:
            r105 = false;
            goto L48
        L39:
            if (r103.isVideo() == true) goto L41;
            r105 = r118.f445898n.A2();
            goto L48
        L41:
            if (r118.S == true) goto L43;
            r105 = r118.f445898n.z2();
            goto L48
        L43:
            if (((ArrayList) r118.f445898n.f447457b).size() <= 0) goto L45;
        L32:
            r119 = false;
        L50:
            r102.f445916a.setOnClickListener(new com.ss.android.lark.widget.halfscreen.f(this, r102));
            r102.f445919d.setOnClickListener(new g(r102));
            r102.f445918c.setOnClickListener(new h(this, r102, r103));
            return;
        L26:
            r102.f445918c.setText("");
            goto L27
        L22:
            r102.f445921f.setVisibility(8);
            goto L23
        L18:
            r102.f445917b.setVisibility(8);
            goto L19
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            return new PhotoViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.kb_item_chat_tool_box_photo, r100, false));
        }
    }

    public class a implements gdc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkPhotoPickerView f445924a;

        public a(LarkPhotoPickerView r100) {
            this.f445924a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkPhotoPickerView f445925a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f445925a.G == false) goto L9;
            Log.i("PhotoPickerView", "refresh Picker Info");     // Catch: Throwable -> L6
            this.f445925a.g(true);     // Catch: Throwable -> L6
            return;
        }

        public b(LarkPhotoPickerView r100) {
            this.f445925a = r100;
        }
    }

    public class c extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkPhotoPickerView f445926a;

        public c(LarkPhotoPickerView r100) {
            this.f445926a = r100;
            super(null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            UICallbackExecutor.removeCallbacks(this.f445926a.V);
            UICallbackExecutor.executeDelayed(this.f445926a.V, 3000);
        }
    }

    public interface d {

        public interface a {
            void a(int r100);

            void b();

            void c(int r100);

            boolean d();

            boolean e();

            void f(List<Photo> r100, boolean r101);

            void g(Photo r100, boolean r101, boolean r102);

            void h(List<Photo> r100, boolean r101, String r102);

            void i(List<Photo> r100, boolean r101);
        }

        void a();

        void b(PhotoPreviewPickerParam r100);

        a c();

        void d(PhotoPickerParam r100);
    }

    public interface e {
    }

    public static class f implements j.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LarkPhotoPickerView> f445927a;

        public f(LarkPhotoPickerView r100) {
            this.f445927a = new WeakReference(r100);
        }
    }

    public final void d() {
        this.G = false;
        b();
        RecyclerView r100 = (RecyclerView) findViewById(R.id.recyclerview_photo);
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f445898n.getItemCount() <= 0) goto L9;
        r100.scrollToPosition(0);
        return;
    }

    public void setPhotoPermissionListener(e r100) {
    }

    private gdc.a getOnItemCheckListener() {
        return new a(this);
    }

    public final void b() {
        PhotoHorizontalAdapter r100 = this.f445898n;
        ((ArrayList) r100.f447457b).clear();
        r100.notifyDataSetChanged();
        boolean r101 = false;
        this.f445902r = 0;
        if (this.f445900p <= 0) goto L5;
        r101 = true;
    L5:
        setCameraBtnEnable(r101);
        k(this.f445902r);
    }

    public List<Photo> getSelectedPhoto() {
        return this.f445898n.f447457b;
    }

    public final boolean j() {
        if (this.G == true) goto L6;
        g(false);
        Log.i("LarkPhotoPickerView", "startScan success");
        return true;
    L6:
        Log.i("LarkPhotoPickerView", "startScan fail");
        return false;
    }

    public final void i() {
        StoragePermissionUtils.c r100 = new StoragePermissionUtils.c(getContext(), new String[0]);
        Log.i("LarkPhotoPickerView", "showPermissionElements / " + r100);
        int r101 = r100.f438544a;
        if (r101 != 2) goto L6;
        this.f445906v.setVisibility(0);
        this.f445907w.setVisibility(8);
        this.D.setVisibility(8);
        return;
    L6:
        if (r101 == 1) goto L8;
        this.f445906v.setVisibility(8);
        this.f445907w.setVisibility(8);
        this.D.setVisibility(0);
        return;
    L8:
        if (this.T == true) goto L10;
    L12:
        this.f445906v.setVisibility(8);
        this.f445907w.setVisibility(0);
        this.D.setVisibility(0);
        return;
    L10:
        if (CollectionUtils.isEmpty(this.f445898n.y2()) == false) goto L12;
        this.f445906v.setVisibility(0);
        this.f445907w.setVisibility(0);
        this.D.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.W);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.W);
        this.U.shutdownNow();
        UICallbackExecutor.removeCallbacks(this.V);
    }

    public LarkPhotoPickerView(Context r100) {
        this(r100, null);
    }

    public static void a(LarkPhotoPickerView r100) {
        int r101 = r100.f445899o.findLastVisibleItemPosition();
        if (r101 < 0) goto L28;
        View r102 = r100.f445899o.findViewByPosition(r101);
        if (r102 == null) goto L17;
        RelativeLayout r103 = (RelativeLayout) r102.findViewById(R.id.v_selected_region);
        if (r103 == null) goto L17;
        Rect r104 = new Rect();
        if (r102.getLocalVisibleRect(r104) == false) goto L17;
        int r105 = r103.getWidth();
        int r106 = r102.getWidth() - r105;
        int r107 = r104.right;
        if (r107 >= r105) goto L16;
        r103.offsetLeftAndRight(-((int) r103.getX()));
        goto L17
    L16:
        r103.offsetLeftAndRight(Math.min(r106, r107 - r105) - ((int) r103.getX()));
    L17:
        int r108 = r101 - 1;
        if (r108 < 0) goto L29;
        View r109 = r100.f445899o.findViewByPosition(r108);
        if (r109 == null) goto L30;
        RelativeLayout r110 = (RelativeLayout) r109.findViewById(R.id.v_selected_region);
        if (r110 == null) goto L31;
        r110.offsetLeftAndRight(((r109.getWidth() - r110.getWidth()) - ((ViewGroup.MarginLayoutParams) r110.getLayoutParams()).rightMargin) - ((int) r110.getX()));
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void g(boolean r100) {
        Context r101 = getContext();
        new HashMap();
        int r102 = 2;
        int r103 = StoragePermissionUtils.a(r101, StoragePermissionUtils.d(r101, 2));
        StoragePermissionUtils.a(r101, StoragePermissionUtils.d(r101, 4));
        StoragePermissionUtils.d(r101, 8);
        StoragePermissionUtils.e(r101);
        boolean r104 = false;
        if (r103 != 0) goto L5;
        boolean r105 = true;
    L6:
        Context r106 = getContext();
        new HashMap();
        int r107 = StoragePermissionUtils.a(r106, StoragePermissionUtils.d(r106, 2));
        StoragePermissionUtils.a(r106, StoragePermissionUtils.d(r106, 4));
        StoragePermissionUtils.d(r106, 8);
        StoragePermissionUtils.e(r106);
        if (r107 != 1) goto L9;
        boolean r108 = true;
    L11:
        if (r105 == true) goto L15;
        if (r108 == true) goto L15;
        Log.i("LarkPhotoPickerView", "load Media no permission");
    L33:
        PhotoPartialStoragePermissionNotice r109 = this.f445907w;
        if (this.f445884J == false) goto L36;
        r102 = 6;
    L36:
        r109.setMediaType(r102);
        this.f445907w.setOnUserSelectResultListener(new jcc.a(this));
        return;
    L15:
        this.G = true;
        if (r100 == true) goto L18;
        b();
    L18:
        Bundle r110 = new Bundle();
        r110.putBoolean("SHOW_GIF", this.I);
        if (this.f445884J == true) goto L21;
    L25:
        r110.putBoolean("SHOW_VIDEO", r104);
        FragmentActivity r111 = (FragmentActivity) new WeakReference((FragmentActivity) ContextsKt.requireActivity(getContext())).get();
        f r112 = new f(this);
        ExecutorService r113 = this.U;
        j.f447665d = true;
        j.f447666e = System.currentTimeMillis();
        if (r111 != null) goto L28;
        Log.w("MediaStoreHelper", "getPhotoDirs, activity is null");
    L32:
        Log.i("LarkPhotoPickerView", "load Media ok");
        goto L33
    L28:
        LoaderManager r114 = r111.getSupportLoaderManager();
        j.b r115 = new j.b(r111, r112, r113);
        if (r114.getLoader(R.id.loader_photo) != null) goto L31;
        r114.initLoader(R.id.loader_photo, r110, r115);
        goto L32
    L31:
        r114.restartLoader(R.id.loader_photo, r110, r115);
        goto L32
    L21:
        if (this.O == true) goto L23;
    L24:
        r104 = true;
        goto L25
    L23:
        if (this.P == false) goto L25;
    L9:
        r108 = false;
        goto L11
    L5:
        r105 = false;
        goto L6
    }

    public final void k(int r110) {
        boolean r100 = this.R;
        if (r100 == false) goto L5;
        int r101 = R.string.Lark_Legacy_PickerSendEnsure;
    L7:
        if (r100 == true) goto L15;
        d r102 = this.H;
        if (r102 == null) goto L15;
        if (r102.c() == null) goto L15;
        if (this.H.c().e() == false) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L18;
    L20:
        boolean r104 = false;
    L22:
        if (this.f445894j == true) goto L24;
    L26:
        this.f445894j = true;
        this.f445895k = r104;
        if (r104 == false) goto L29;
        float r105 = -UIHelper.dp2px(12.0f);
    L30:
        this.f445910z.setTranslationY(r105);
        this.A.setTranslationY(r105);
        if (r104 == false) goto L33;
        float r106 = 16.0f;
    L34:
        int r107 = UIHelper.dp2px(r106);
        UDCheckBox r108 = this.f445896l;
        r108.setPadding(r107, r108.getPaddingTop(), this.f445896l.getPaddingRight(), this.f445896l.getPaddingBottom());
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) this.f445897m.getLayoutParams();
        if (r104 == false) goto L37;
        float r111 = 7.0f;
    L38:
        r109.leftMargin = -UIHelper.dp2px(r111);
        this.f445897m.setLayoutParams(r109);
    L39:
        if (r103 == false) goto L42;
        if (r104 == true) goto L42;
        boolean r112 = true;
    L44:
        if (this.f445892h == true) goto L46;
    L48:
        this.f445892h = true;
        this.f445893i = r112;
        LinearLayout.LayoutParams r113 = (LinearLayout.LayoutParams) this.f445908x.getLayoutParams();
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) this.f445890f.getLayoutParams();
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) this.f445891g.getLayoutParams();
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) this.f445889e.getLayoutParams();
        if (r112 == false) goto L51;
        r113.width = -2;
        r113.weight = 0.0f;
        r114.width = UIHelper.dp2px(20.0f);
        r115.width = 0;
        r115.weight = 1.0f;
        r116.rightMargin = UIHelper.dp2px(12.0f);
    L52:
        this.f445908x.setLayoutParams(r113);
        this.f445890f.setLayoutParams(r114);
        this.f445891g.setLayoutParams(r115);
        this.f445889e.setLayoutParams(r116);
    L53:
        if (r103 == false) goto L56;
        if (r110 <= 0) goto L56;
        boolean r117 = true;
    L57:
        View r118 = this.f445887c;
        if (r112 == false) goto L60;
        int r119 = 0;
    L61:
        r118.setVisibility(r119);
        this.f445887c.setEnabled(r117);
        this.f445889e.setEnabled(r117);
        PhotoInsertToInputView r120 = this.f445888d;
        if (r104 == false) goto L65;
        if (r117 == false) goto L65;
        boolean r121 = true;
    L66:
        r120.a(r121, true);
        this.f445888d.setEnabled(r117);
        if (r110 <= 0) goto L69;
        this.f445885a.setEnabled(true);
        this.f445886b.setEnabled(true);
        this.f445905u.setVisibility(0);
        this.f445908x.setVisibility(0);
        this.f445905u.setText(UIHelper.mustacheFormat(R.string.Lark_Legacy_Preview, "select_count", Integer.toString(r110)));
        this.f445886b.setText(r101);
    L70:
        d r122 = this.H;
        if (r122 != null) goto L73;
        return;
    L73:
        if (r122.c() == null) goto L77;
        this.H.c().b();
        return;
    L77:
        return;
    L69:
        this.f445885a.setEnabled(false);
        this.f445905u.setVisibility(8);
        this.f445908x.setVisibility(4);
        this.f445886b.setEnabled(false);
        this.f445886b.setText(getContext().getString(r101));
    L65:
        r121 = false;
        goto L66
    L60:
        r119 = 8;
    L56:
        r117 = false;
        goto L57
    L51:
        r113.width = 0;
        r113.weight = 1.0f;
        r114.width = UIHelper.dp2px(8.0f);
        r115.width = UIHelper.dp2px(8.0f);
        r115.weight = 0.0f;
        r116.rightMargin = UIHelper.dp2px(16.0f);
        goto L52
    L46:
        if (this.f445893i != r112) goto L48;
    L42:
        r112 = false;
        goto L44
    L37:
        r111 = 5.0f;
        goto L38
    L33:
        r106 = 12.0f;
        goto L34
    L29:
        r105 = 0.0f;
        goto L30
    L24:
        if (this.f445895k != r104) goto L26;
    L18:
        if (this.H.c().d() == false) goto L20;
        r104 = true;
    L15:
        r103 = false;
        goto L16
    L5:
        r101 = R.string.Lark_Legacy_PickerSend;
        goto L7
    }

    public void setCameraBtnEnable(boolean r100) {
        this.f445910z.setEnabled(r100);
        this.f445910z.setClickable(r100);
    }

    public void setCurrentMode(int r100) {
        if (r100 == this.F) goto L5;
        this.G = false;
    L5:
        this.F = r100;
        k(this.f445902r);
    }

    public void setEnablePostSendVideo(boolean r100) {
        this.P = r100;
    }

    public void setImageVideoExclusive(boolean r100) {
        this.Q = r100;
    }

    public void setInConfirmMode(boolean r100) {
        this.R = r100;
    }

    public void setIsInPostMode(boolean r100) {
        this.O = r100;
        this.Q = r100;
        this.S = r100;
        this.R = r100;
        k(this.f445902r);
    }

    public void setIsShowOriginalCheckBox(boolean r100) {
        this.f445904t = r100;
        ViewGroup r101 = this.f445909y;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        r101.setVisibility(0);
        return;
    L7:
        r101.setVisibility(4);
    }

    public void setMaxCount(int r100) {
        this.f445900p = r100;
        UDCheckBox r101 = this.f445896l;
        boolean r102 = true;
        if (r100 <= 0) goto L5;
        boolean r103 = true;
    L6:
        r101.setEnabled(r103);
        View r104 = this.f445897m;
        if (r100 > 0) goto L10;
        r102 = false;
    L10:
        r104.setEnabled(r102);
        this.f445896l.setChecked(false);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public void setOriginChecked(boolean r100) {
        UDCheckBox r101 = this.f445896l;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setChecked(r100);
    }

    public void setPartialPermissionNoticeBgColor(int r100) {
        this.f445907w.setBackgroundColor(r100);
    }

    public void setPhotoItemConfig(o r100) {
        this.f445898n.getClass();
    }

    public void setPhotoPickerListener(d r100) {
        this.H = r100;
        k(this.f445902r);
    }

    public void setRootBackgroundColor(int r100) {
        this.E.setBackgroundColor(r100);
    }

    public void setShowDeniedOnPartialAndNoPicture(boolean r100) {
        this.T = r100;
    }

    public void setShowGif(boolean r100) {
        this.I = r100;
    }

    public void setShowVideo(boolean r100) {
        this.f445884J = r100;
    }

    public void setSingleShowSelector(boolean r100) {
        this.K = r100;
    }

    public void setSingleVideo(boolean r100) {
        this.S = r100;
    }

    public void setToastTotalMaxCount(boolean r100) {
        this.L = r100;
    }

    public void setTotalHasVideo(boolean r100) {
        this.M = r100;
    }

    public void setTotalMaxCount(int r100) {
        this.f445901q = r100;
    }

    public LarkPhotoPickerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void f(List<Photo> r100, boolean r101) {
        d r102 = this.H;
        if (r102 == null) goto L5;
        r102.c().f(r100, r101);
    L5:
        if (r101 == false) goto L10;
        if (this.f445896l.isEnabled() == false) goto L10;
        this.f445896l.setChecked(false);
    L10:
        if (this.N == null) goto L12;
        this.f445898n.getClass();
        this.f445898n.y2().clear();
        this.f445898n.y2().addAll(this.N);
    L12:
        b();
    }

    public LarkPhotoPickerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f445900p = 9;
        this.f445901q = -1;
        this.f445904t = true;
        this.T = false;
        this.U = PThreadExecutorsUtils.newSingleThreadExecutor(new n("PhotoLoader"));
        this.V = new b(this);
        this.W = new c(this);
        LayoutInflater.from(ContextsKt.preferActivity(getContext())).inflate(R.layout.kb_chat_tool_box_photo_view, this, true);
        this.f445906v = (FrameLayout) findViewById(R.id.no_permission_layout);
        LinearLayout r103 = (LinearLayout) findViewById(R.id.default_photo_permission_denied_layout);
        this.f445907w = (PhotoPartialStoragePermissionNotice) findViewById(R.id.partial_permission_notice);
        this.f445886b = (TextView) findViewById(R.id.btn_photo_send);
        this.f445885a = findViewById(R.id.layout_photo_send);
        this.f445896l = (UDCheckBox) findViewById(R.id.cb_original_photo);
        this.f445897m = findViewById(R.id.original_label);
        this.f445908x = (ViewGroup) findViewById(R.id.preview_container);
        this.f445890f = findViewById(R.id.original_preview_space);
        this.f445891g = findViewById(R.id.preview_action_space);
        this.f445909y = (ViewGroup) findViewById(R.id.layout_original_photo);
        CommonRecyclerView r104 = (CommonRecyclerView) findViewById(R.id.recyclerview_photo);
        r104.setSceneTag("album_horizontal_component");
        this.A = findViewById(R.id.btn_photo_album);
        TextView r105 = (TextView) findViewById(R.id.btn_photo_permission_denied);
        this.f445910z = findViewById(R.id.camera_btn);
        this.B = findViewById(R.id.left_tool_container);
        this.C = findViewById(R.id.chat_menu_post);
        this.E = findViewById(R.id.root_layout);
        l r106 = new l(this, getContext());
        this.f445899o = r106;
        r104.setLayoutManager(r106);
        PhotoHorizontalAdapter r107 = new PhotoHorizontalAdapter(this);
        this.f445898n = r107;
        r104.setAdapter(r107);
        PhotoHorizontalAdapter r108 = this.f445898n;
        r108.f445914f = getOnItemCheckListener();
        PhotoHorizontalAdapter r109 = this.f445898n;
        r109.f445913e = new com.ss.android.lark.widget.halfscreen.b(this);
        this.A.setOnClickListener(new m(this));
        r105.setOnClickListener(new jcc.d(this));
        this.f445910z.setOnClickListener(new com.ss.android.lark.widget.halfscreen.c(this));
        this.f445886b = (TextView) findViewById(R.id.btn_photo_send);
        this.f445885a = findViewById(R.id.layout_photo_send);
        this.f445889e = (TextView) findViewById(R.id.btn_photo_insert_message);
        this.f445887c = findViewById(R.id.layout_photo_insert_message);
        this.f445888d = (PhotoInsertToInputView) findViewById(R.id.layout_photo_insert_message_new);
        this.f445905u = (TextView) findViewById(R.id.btn_photo_preview);
        this.f445887c.setOnClickListener(new com.ss.android.lark.widget.halfscreen.d(this));
        this.f445888d.setOnInsertClickListener(new jcc.e(this));
        this.f445885a.setOnClickListener(new com.ss.android.lark.widget.halfscreen.e(this));
        this.f445896l.setOnCheckedChangeListener(new jcc.f(this));
        this.f445909y.setOnClickListener(new jcc.n(this));
        this.f445905u.setOnClickListener(new com.ss.android.lark.widget.halfscreen.a(this));
        r104.addOnScrollListener(new k(this));
        r104.onScrollStateChanged(0);
        r104.setFpsCallback(new jcc.g());
        this.D = r104;
    }

    public final void e(int r110, int r111, Intent r112) {
        if (r112 != null) goto L5;
        return;
    L5:
        if (r110 != 911) goto L34;
        if (r111 != (-1)) goto L62;
        ArrayList<Photo> r100 = (ArrayList) r112.getSerializableExtra("KEY_SELECTED_MEDIA");
        boolean r113 = r112.getBooleanExtra("KEY_HAS_VIDEO", false);
        boolean r101 = r112.getBooleanExtra("is_send_photo", false);
        boolean r102 = r112.getBooleanExtra("is_insert_to_input", false);
        boolean r114 = r112.getBooleanExtra("KEEP_ORIGIN_PHOTO", false);
        String r115 = r112.getStringExtra("choose_image_source");
        if (r100 != null) goto L12;
        Log.e("LarkPhotoPickerView", "return from photo preview picker, selected media is null");
        return;
    L12:
        Log.i("LarkPhotoPickerView", "return from photo preview picker, photoCount = " + r100.size());
        if (r113 == false) goto L15;
    L32:
        c(r100, r101, r102, r114, r115);
        return;
    L15:
        if (CollectionUtils.isNotEmpty(this.f445898n.y2()) == false) goto L32;
        this.f445896l.setChecked(r114);
        ArrayList<String> r116 = r112.getStringArrayListExtra("photo_new_old_map");
        this.N = new ArrayList(this.f445898n.y2());
        this.f445898n.getClass();
        if (r116 != null) goto L19;
    L31:
        c(r100, r101, r102, r114, r115);
        return;
    L19:
        if (r116.size() <= 0) goto L31;
        List<Photo> r117 = this.f445898n.y2();
        int r118 = 0;
    L22:
        if (r118 >= r116.size()) goto L31;
        String r103 = (String) ListProtector.get(r116, r118);
        String r104 = (String) ListProtector.get(r116, r118 + 1);
        int r105 = 0;
    L25:
        if (r105 >= r117.size()) goto L30;
        if (r103.equals(((Photo) ListProtector.get(r117, r105)).getPath()) == true) goto L28;
        r105 = r105 + 1;
        goto L25
    L28:
        Photo r106 = new Photo((Photo) ListProtector.get(r117, r105));
        r106.setPath(r104);
        ListProtector.set(r117, r105, r106);
    L30:
        r118 = r118 + 2;
        goto L22
    L62:
        return;
    L34:
        if (r110 != 233) goto L65;
        boolean r107 = r112.getBooleanExtra("KEY_FOR_SEND", true);
        boolean r108 = r112.getBooleanExtra("KEY_IS_INSERT_TO_INPUT", false);
        if (r108 == false) goto L45;
        d r119 = this.H;
        if (r119 != null) goto L40;
    L43:
        Log.i("LarkPhotoPickerView", "ignore insert-to-input result because capability is disabled");
        return;
    L40:
        if (r119.c() == null) goto L43;
        if (this.H.c().e() == false) goto L43;
    L45:
        boolean r120 = r112.getBooleanExtra("KEEP_ORIGIN_PHOTO", false);
        boolean r121 = r112.getBooleanExtra("KEY_RET_FROM_CAMERA", false);
        ArrayList<Photo> r109 = (ArrayList) r112.getSerializableExtra("KEY_SELECTED_MEDIA");
        String r122 = r112.getStringExtra("choose_image_source");
        StringBuilder r123 = new StringBuilder("return from photo picker, photoCount = ");
        if (r109 == null) goto L48;
        int r124 = r109.size();
    L49:
        r123.append(r124);
        r123.append(", isFromCamera:");
        r123.append(r121);
        r123.append(", keep origin: ");
        r123.append(r120);
        Log.i("LarkPhotoPickerView", r123.toString());
        if (r109 != null) goto L53;
        Log.e("LarkPhotoPickerView", "return from photo picker, selected media is null");
        return;
    L53:
        Context r125 = getContext();
        new HashMap();
        int r126 = StoragePermissionUtils.a(r125, StoragePermissionUtils.d(r125, 2));
        StoragePermissionUtils.a(r125, StoragePermissionUtils.d(r125, 4));
        StoragePermissionUtils.d(r125, 8);
        StoragePermissionUtils.e(r125);
        if (r126 != 1) goto L56;
        g(false);
    L56:
        this.f445896l.setChecked(r120);
        c(r109, r107, r108, r120, r122);
        return;
    L48:
        r124 = 0;
        goto L49
    }

    public final void h(List<Photo> r100, boolean r101, String r102) {
        d r103 = this.H;
        if (r103 == null) goto L5;
        r103.c().h(r100, r101, r102);
    L5:
        if (r101 == false) goto L10;
        if (this.f445896l.isEnabled() == false) goto L10;
        this.f445896l.setChecked(false);
    L10:
        if (this.N == null) goto L12;
        this.f445898n.getClass();
        this.f445898n.y2().clear();
        this.f445898n.y2().addAll(this.N);
    L12:
        b();
    }

    public final void c(final ArrayList<Photo> r100, final boolean r101, final boolean r102, final boolean r110, String r111) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        r111 = "album";
    L5:
        final String r103 = r111;
        RxScheduledExecutor.execInIO(new jcc.b(r100), new jcc.c(this, r102, r110, r101, r103));
    }
}
