package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.table.m;
import com.bytedance.ee.bear.bitable.card.view.table.x;
import com.bytedance.ee.bear.bitable.card.view.table.y;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.CoverFitType;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ip4.s;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 F2\u00020\u0001:\u0001FB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001b\u001a\u00020\u00142\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ+\u0010\u001d\u001a\u00020\u00142#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u000eJ(\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\b\u0010%\u001a\u00020\fH\u0016J\u0018\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\fH\u0016J \u0010/\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\f2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00100\u001a\u00020\f2\u0006\u0010)\u001a\u00020*H\u0016J \u00101\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\f2\u0006\u0010)\u001a\u00020*H\u0016J\u000e\u00102\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\fJ\u0006\u00103\u001a\u00020\fJB\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00162\b\u00106\u001a\u0004\u0018\u00010\u00162\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u000eH\u0002J\"\u0010=\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00162\u0006\u00107\u001a\u0002082\u0006\u0010>\u001a\u00020(H\u0002J\u001a\u0010?\u001a\u00020\u00142\b\u00106\u001a\u0004\u0018\u00010\u00162\u0006\u0010:\u001a\u000208H\u0002J\u0010\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u000208H\u0002J\u0010\u0010B\u001a\u00020\u00142\u0006\u0010A\u001a\u000208H\u0002J\u0018\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020E2\u0006\u00107\u001a\u000208H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006G"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mCovers", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "mCurPosition", "", "mCoverFitType", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/CoverFitType;", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "objToken", "", "getObjToken", "()Ljava/lang/String;", "setObjToken", "(Ljava/lang/String;)V", "setData", "covers", "setOnClickListener", "listener", "setCoverFitType", "fitType", "isDataChange", "", "old", "new", "getCount", "isViewFromObject", "view", "Landroid/view/View;", "object", "", "instantiateItem", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "position", "destroyItem", "getItemPosition", "setPrimaryItem", "setCurrentPosition", "getCurrentPosition", "renderCoverImage", "localPath", "fileName", "coverImageView", "Landroid/widget/ImageView;", "loadingImageView", "videoPlayBtn", "coverView", "coverFitType", "renderPlaceholderView", "coverContainer", "checkVideoPlayBtnStatus", "renderLoadingView", "coverLoadingView", "dismissLoadingView", "renderCoverImageBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryCoverAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f213452g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f213453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends AttachmentEntity> f213454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f213455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoverFitType f213456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Integer, Unit> f213457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f213458f;

    public static final class a {
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryCoverAdapter f213459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f213460b;

        @Override // com.bytedance.ee.bear.bitable.card.view.table.m
        public final void a() {
            Function1<? super Integer, Unit> r100 = this.f213459a.f213457e;
            if (r100 == null) goto L6;
            r100.invoke(Integer.valueOf(this.f213460b));
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.table.m
        public final String getToken() {
            return this.f213459a.f213458f;
        }

        public b(GalleryCoverAdapter r100, int r101) {
            this.f213459a = r100;
            this.f213460b = r101;
        }
    }

    public static final class c implements w85.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryCoverAdapter f213461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f213462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AttachmentEntity f213463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ImageView f213464d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ImageView f213465e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ View f213466f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ CoverFitType f213467g;

        @Override // w85.a.b
        public final void e(String r100) {
            GalleryCoverAdapter r101 = this.f213461a;
            ImageView r102 = this.f213462b;
            Intrinsics.checkNotNull(r102);
            int r103 = GalleryCoverAdapter.f213452g;
            r101.getClass();
            j.f(new f(r102, r101));
        }

        @Override // w85.a.b
        public final void c(String r110, w85.b r111) {
            if (r111 == null) goto L13;
            File r112 = r111.f558653b;
            if (r112 == null) goto L14;
            String r100 = r112.getAbsolutePath();
            if (r100 == null) goto L15;
            GalleryCoverAdapter r101 = this.f213461a;
            AttachmentEntity r113 = this.f213463c;
            ImageView r102 = this.f213464d;
            ImageView r103 = this.f213462b;
            ImageView r104 = this.f213465e;
            View r105 = this.f213466f;
            CoverFitType r106 = this.f213467g;
            if (r113 == null) goto L10;
            String r114 = r113.getName();
        L11:
            String r107 = r114;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            Intrinsics.checkNotNull(r104);
            Intrinsics.checkNotNull(r105);
            int r115 = GalleryCoverAdapter.f213452g;
            r101.getClass();
            j.f(new d(r106, r102, r101, r100, r107, r105, r103, r104));
            return;
        L10:
            r114 = null;
            goto L11
        L15:
            return;
        L14:
            return;
        }

        @Override // w85.a.b
        public final void a(String r110, String r111, int r112) {
            tt5.a.d("GalleryCoverAdapter", "onFailed, key = " + r111 + ", errorCode = " + r112);
            AttachmentEntity r113 = this.f213463c;
            String r114 = null;
            if (r113 == null) goto L10;
            String r100 = r113.getAvailableLocalPath();
            if (r100 == null) goto L10;
            GalleryCoverAdapter r101 = this.f213461a;
            AttachmentEntity r115 = this.f213463c;
            ImageView r102 = this.f213464d;
            ImageView r103 = this.f213462b;
            ImageView r104 = this.f213465e;
            View r105 = this.f213466f;
            CoverFitType r106 = this.f213467g;
            tt5.a.h("GalleryCoverAdapter", "download failed, then render cover by available non-empty local path");
            if (r115 == null) goto L9;
            r114 = r115.getName();
        L9:
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            Intrinsics.checkNotNull(r104);
            Intrinsics.checkNotNull(r105);
            int r116 = GalleryCoverAdapter.f213452g;
            r101.getClass();
            j.f(new d(r106, r102, r101, r100, r114, r105, r103, r104));
            return;
        L10:
            GalleryCoverAdapter r117 = this.f213461a;
            AttachmentEntity r107 = this.f213463c;
            ImageView r108 = this.f213464d;
            View r109 = this.f213466f;
            ImageView r118 = this.f213462b;
            tt5.a.h("GalleryCoverAdapter", "download failed, no local path, render default cover");
            if (r107 == null) goto L13;
            r114 = r107.getName();
        L13:
            Intrinsics.checkNotNull(r108);
            Intrinsics.checkNotNull(r109);
            int r119 = GalleryCoverAdapter.f213452g;
            r117.getClass();
            j.f(new g(r114, r108, r117, r109));
            Intrinsics.checkNotNull(r118);
            j.f(new com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover.b(r118));
        }

        public c(GalleryCoverAdapter r100, ImageView r101, AttachmentEntity r102, ImageView r103, ImageView r104, View r105, CoverFitType r106) {
            this.f213461a = r100;
            this.f213462b = r101;
            this.f213463c = r102;
            this.f213464d = r103;
            this.f213465e = r104;
            this.f213466f = r105;
            this.f213467g = r106;
        }
    }

    static {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "object");
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        List<? extends AttachmentEntity> r100 = this.f213454b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final Context getContext() {
        return this.f213453a;
    }

    public GalleryCoverAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f213453a = r100;
        this.f213456d = CoverFitType.FIT;
    }

    public final void f(List<? extends AttachmentEntity> r100) {
        List<? extends AttachmentEntity> r101 = this.f213454b;
        if (r101 != null) goto L6;
        if (r100 != null) goto L6;
    L18:
        boolean r102 = false;
    L21:
        if (r102 == false) goto L23;
        tt5.a.h("GalleryCoverAdapter", "notifyCoverDataUpdate");
        this.f213454b = r100;
        this.f213455c = 0;
        notifyDataSetChanged();
        return;
    L23:
        tt5.a.h("GalleryCoverAdapter", "no data changed");
        return;
    L6:
        if (r101 == null) goto L19;
        if (r100 == null) goto L19;
        if (r101.size() != r100.size()) goto L19;
        int r103 = r101.size();
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L18;
        if (Intrinsics.areEqual(((AttachmentEntity) ListProtector.get(r101, r104)).getId(), ((AttachmentEntity) ListProtector.get(r100, r104)).getId()) == false) goto L19;
        r104 = r104 + 1;
    L19:
        r102 = true;
        goto L21
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        tt5.a.h("GalleryCoverAdapter", "instantiateItem, position = " + r111);
        View r100 = LayoutInflater.from(r110.getContext()).inflate(R.layout.bitable_card_cover_item_view, r110, false);
        ImageView r101 = (ImageView) r100.findViewById(R.id.cover_main_view);
        r101.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageView r102 = (ImageView) r100.findViewById(R.id.cover_main_view_video_play);
        if (r102.getDrawable() != null) goto L5;
        r102.setImageResource(R.drawable.ud_icon_play_round_colorful);
    L5:
        ImageView r103 = (ImageView) r100.findViewById(R.id.cover_main_view_loading);
        List<? extends AttachmentEntity> r104 = this.f213454b;
        String r112 = null;
        if (r104 == null) goto L8;
        AttachmentEntity r105 = (AttachmentEntity) ListProtector.get(r104, r111);
    L9:
        CoverFitType r113 = this.f213456d;
        y r114 = new y();
        r114.f208924a = r100;
        r100.setOnClickListener(new x(r114));
        r114.f208925b = new b(this, r111);
        if (r105 == null) goto L12;
        String r115 = r105.getName();
    L14:
        if (s.d(r115) == true) goto L20;
        if (r105 == null) goto L17;
        String r116 = r105.getName();
    L19:
        if (s.c(r116) == true) goto L20;
    L24:
        if (r105 == null) goto L26;
        r112 = r105.getName();
    L26:
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNull(r100);
        j.f(new g(r112, r101, this, r100));
    L36:
        r110.addView(r100);
        return r114;
    L17:
        r116 = null;
    L20:
        int r117 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.fix_attach_preview_over_permission") == true) goto L23;
    L27:
        c r118 = new c(this, r103, r105, r101, r102, r100, r113);
        w85.a.C8081a r106 = new w85.a.C8081a();
        r106.f558639a = true;
        if (r105 == null) goto L30;
        String r107 = r105.getAttachmentToken();
    L31:
        r106.f558643e = r107;
        r106.f558640b = DownloadRequestInfo.DownloadType.COVER;
        r106.f558649k = new DownloadRequestInfo.b(1280, 1280, "near", false);
        r106.f558650l = 0;
        r106.f558648j = r118;
        if (r105 == null) goto L34;
        String r119 = r105.getExtra();
    L35:
        r106.f558651m = r119;
        r106.f558645g = "bitable_image";
        ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).d(new w85.a(r106));
        goto L36
    L34:
        r119 = null;
        goto L35
    L30:
        r107 = null;
        goto L31
    L23:
        if (com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.f.a(this.f213458f) == true) goto L27;
    L12:
        r115 = null;
        goto L14
    L8:
        r105 = null;
        goto L9
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "object");
        return Intrinsics.areEqual(r100, ((y) r101).f208924a);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        if ((r102 instanceof y) == false) goto L5;
        tt5.a.h("GalleryCoverAdapter", "destroyItem position : " + r101);
        y r103 = (y) r102;
        r100.removeView(r103.f208924a);
        r103.f208924a = null;
        r103.f208925b = null;
        return;
    L5:
        tt5.a.h("GalleryCoverAdapter", "destroyItem container is null or object type is illegal");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        super.setPrimaryItem(r100, r101, r102);
    }
}
