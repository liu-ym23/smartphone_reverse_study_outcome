package com.bytedance.ee.bear.bitable.card.view.table;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 72\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000bJ\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J \u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010!\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u000fJ\u001e\u0010#\u001a\u00020\u00152\u0014\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000bH\u0002J:\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0017H\u0002J\"\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020)2\u0006\u0010/\u001a\u00020\u0017H\u0002J\u001a\u00100\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020)H\u0002J\u0010\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020)H\u0002J\u0010\u00103\u001a\u00020\u00112\u0006\u00102\u001a\u00020)H\u0002J\u0018\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/table/RecordPageCoverAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "delegate", "Lcom/bytedance/ee/bear/bitable/card/view/table/IPageCoverDelegate;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/card/view/table/IPageCoverDelegate;)V", "getContext", "()Landroid/content/Context;", "mSTCell", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/STCell;", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "mCurPosition", "", "updateRecords", "", "stCell", "getCount", "isViewFromObject", "", "view", "Landroid/view/View;", "object", "", "getAttachmentEntity", "position", "instantiateItem", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "destroyItem", "getItemPosition", "setPrimaryItem", "setCurrentPosition", "cellValueHasChange", "renderCoverImage", "localPath", "", "fileName", "coverImageView", "Landroid/widget/ImageView;", "loadingImageView", "videoPlayBtn", "coverView", "renderPlaceholderView", "name", "coverContainer", "checkVideoPlayBtnStatus", "renderLoadingView", "coverLoadingView", "dismissLoadingView", "renderCoverImageBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RecordPageCoverAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f208851d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f208852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f208853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public dp4.a<List<AttachmentEntity>> f208854c;

    public static final class a {
    }

    public static final class b implements w85.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordPageCoverAdapter f208855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f208856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AttachmentEntity f208857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ImageView f208858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ImageView f208859e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ View f208860f;

        @Override // w85.a.b
        public final void e(String r100) {
            RecordPageCoverAdapter r101 = this.f208855a;
            ImageView r102 = this.f208856b;
            Intrinsics.checkNotNull(r102);
            int r103 = RecordPageCoverAdapter.f208851d;
            r101.getClass();
            com.bytedance.ee.util.ui.j.f(new v(r102, r101));
        }

        @Override // w85.a.b
        public final void c(String r100, w85.b r110) {
            if (r110 == null) goto L13;
            File r101 = r110.f558653b;
            if (r101 == null) goto L14;
            String r102 = r101.getAbsolutePath();
            if (r102 == null) goto L15;
            RecordPageCoverAdapter r103 = this.f208855a;
            AttachmentEntity r104 = this.f208857c;
            ImageView r105 = this.f208858d;
            ImageView r106 = this.f208856b;
            ImageView r107 = this.f208859e;
            View r108 = this.f208860f;
            if (r104 == null) goto L10;
            String r109 = r104.getName();
        L11:
            String r111 = r109;
            Intrinsics.checkNotNull(r105);
            Intrinsics.checkNotNull(r106);
            Intrinsics.checkNotNull(r107);
            Intrinsics.checkNotNull(r108);
            int r112 = RecordPageCoverAdapter.f208851d;
            r103.getClass();
            com.bytedance.ee.util.ui.j.f(new t(r103, r102, r105, r111, r108, r106, r107));
            return;
        L10:
            r109 = null;
            goto L11
        L15:
            return;
        L14:
            return;
        }

        @Override // w85.a.b
        public final void a(String r100, String r110, int r111) {
            tt5.a.d("RecordPageCoverAdapter", "onFailed, key = " + r110 + ", errorCode = " + r111);
            AttachmentEntity r101 = this.f208857c;
            String r112 = null;
            if (r101 == null) goto L10;
            String r102 = r101.getAvailableLocalPath();
            if (r102 == null) goto L10;
            RecordPageCoverAdapter r103 = this.f208855a;
            AttachmentEntity r104 = this.f208857c;
            ImageView r105 = this.f208858d;
            ImageView r106 = this.f208856b;
            ImageView r107 = this.f208859e;
            View r108 = this.f208860f;
            tt5.a.h("RecordPageCoverAdapter", "download failed, then render cover by available non-empty local path");
            if (r104 == null) goto L9;
            r112 = r104.getName();
        L9:
            Intrinsics.checkNotNull(r105);
            Intrinsics.checkNotNull(r106);
            Intrinsics.checkNotNull(r107);
            Intrinsics.checkNotNull(r108);
            int r109 = RecordPageCoverAdapter.f208851d;
            r103.getClass();
            com.bytedance.ee.util.ui.j.f(new t(r103, r102, r105, r112, r108, r106, r107));
            return;
        L10:
            RecordPageCoverAdapter r113 = this.f208855a;
            AttachmentEntity r114 = this.f208857c;
            ImageView r115 = this.f208858d;
            View r116 = this.f208860f;
            ImageView r117 = this.f208856b;
            tt5.a.h("RecordPageCoverAdapter", "download failed, no local path, render default cover");
            if (r114 == null) goto L13;
            r112 = r114.getName();
        L13:
            Intrinsics.checkNotNull(r115);
            Intrinsics.checkNotNull(r116);
            int r118 = RecordPageCoverAdapter.f208851d;
            r113.getClass();
            com.bytedance.ee.util.ui.j.f(new w(r112, r115, r113, r116));
            Intrinsics.checkNotNull(r117);
            com.bytedance.ee.util.ui.j.f(new r(r117));
        }

        public b(RecordPageCoverAdapter r100, ImageView r101, AttachmentEntity r102, ImageView r103, ImageView r104, View r105) {
            this.f208855a = r100;
            this.f208856b = r101;
            this.f208857c = r102;
            this.f208858d = r103;
            this.f208859e = r104;
            this.f208860f = r105;
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
    public int getCount() {
        dp4.a<List<AttachmentEntity>> r100 = this.f208854c;
        if (r100 == null) goto L12;
        if (r100 == null) goto L6;
        List<AttachmentEntity> r101 = r100.f469598l;
    L7:
        if (r101 == null) goto L12;
        if (r100 == null) goto L12;
        List<AttachmentEntity> r102 = r100.f469598l;
        if (r102 == null) goto L12;
        return r102.size();
    L6:
        r101 = null;
    L12:
        return 0;
    }

    public final Context getContext() {
        return this.f208852a;
    }

    public AttachmentEntity f(int r100) {
        dp4.a<List<AttachmentEntity>> r101 = this.f208854c;
        if (r101 == null) goto L7;
        List<AttachmentEntity> r102 = r101.f469598l;
        if (r102 == null) goto L7;
        return (AttachmentEntity) ListProtector.get(r102, r100);
    L7:
        return null;
    }

    public final void g(dp4.a<List<AttachmentEntity>> r100) {
        if (r100 == null) goto L7;
        fp4.g r101 = r100.f469587a;
        if (r101 == null) goto L7;
        String r102 = r101.f478255b;
    L8:
        dp4.a<List<AttachmentEntity>> r103 = this.f208854c;
        if (r103 == null) goto L13;
        fp4.g r104 = r103.f469587a;
        if (r104 == null) goto L13;
        String r105 = r104.f478255b;
    L15:
        if (TextUtils.equals(r102, r105) == false) goto L67;
        boolean r106 = true;
        if (r100 == null) goto L64;
        dp4.a<List<AttachmentEntity>> r107 = this.f208854c;
        if (r107 == null) goto L64;
        List<AttachmentEntity> r108 = r100.f469598l;
        if (r108 != null) goto L24;
    L63:
        boolean r109 = Intrinsics.areEqual(r108, r107.f469598l);
    L65:
        r106 = true ^ r109;
    L66:
        if (r106 == true) goto L67;
        return;
    L24:
        if (r107.f469598l == null) goto L63;
        Integer r110 = Integer.valueOf(r108.size());
        dp4.a<List<AttachmentEntity>> r111 = this.f208854c;
        if (r111 == null) goto L31;
        List<AttachmentEntity> r112 = r111.f469598l;
        if (r112 == null) goto L31;
        Integer r113 = Integer.valueOf(r112.size());
    L33:
        if (Intrinsics.areEqual(r110, r113) == false) goto L66;
        r106 = false;
        List<AttachmentEntity> r114 = r100.f469598l;     // Catch: Exception -> L61
        if (r114 == null) goto L39;
        int r115 = r114.size();     // Catch: Exception -> L61
    L40:
        int r116 = 0;
    L41:
        if (r116 >= r115) goto L66;
        List<AttachmentEntity> r117 = r100.f469598l;     // Catch: Exception -> L61
        if (r117 == null) goto L45;
        AttachmentEntity r118 = (AttachmentEntity) ListProtector.get(r117, r116);     // Catch: Exception -> L61
    L46:
        dp4.a<List<AttachmentEntity>> r119 = this.f208854c;     // Catch: Exception -> L61
        if (r119 == null) goto L51;
        List<AttachmentEntity> r120 = r119.f469598l;     // Catch: Exception -> L61
        if (r120 == null) goto L51;
        AttachmentEntity r121 = (AttachmentEntity) ListProtector.get(r120, r116);     // Catch: Exception -> L61
    L52:
        if (r118 == null) goto L59;
        if (r121 == null) goto L59;
        if (r118.equals(r121) == false) goto L66;
    L60:
        r116 = r116 + 1;
    L59:
        if (Intrinsics.areEqual(r118, r121) == false) goto L66;
    L51:
        r121 = null;
        goto L52
    L45:
        r118 = null;
        goto L46
    L39:
        r115 = 0;
    L61:
        e = move-exception;
        tt5.a.e("RecordPageCoverAdapter", "compare item error : ", e, false);
    L31:
        r113 = null;
    L64:
        r109 = Intrinsics.areEqual(r100, this.f208854c);
    L67:
        this.f208854c = r100;
        notifyDataSetChanged();
        return;
    L13:
        r105 = null;
    L7:
        r102 = null;
        goto L8
    }

    public RecordPageCoverAdapter(Context r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f208852a = r100;
        this.f208853b = r101;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        tt5.a.h("RecordPageCoverAdapter", "instantiateItem, position = " + r111);
        View r100 = LayoutInflater.from(r110.getContext()).inflate(R.layout.bitable_card_cover_item_view, r110, false);
        ImageView r101 = (ImageView) r100.findViewById(R.id.cover_main_view);
        ImageView r102 = (ImageView) r100.findViewById(R.id.cover_main_view_video_play);
        ImageView r103 = (ImageView) r100.findViewById(R.id.cover_main_view_loading);
        AttachmentEntity r112 = f(r111);
        y r104 = new y();
        r104.f208924a = r100;
        r100.setOnClickListener(new x(r104));
        r104.f208925b = this.f208853b;
        String r113 = null;
        if (r112 == null) goto L5;
        String r105 = r112.getName();
    L7:
        if (ip4.s.d(r105) == true) goto L13;
        if (r112 == null) goto L10;
        String r106 = r112.getName();
    L12:
        if (ip4.s.c(r106) == true) goto L13;
    L17:
        if (r112 == null) goto L19;
        r113 = r112.getName();
    L19:
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNull(r100);
        com.bytedance.ee.util.ui.j.f(new w(r113, r101, this, r100));
    L29:
        r110.addView(r100);
        return r104;
    L10:
        r106 = null;
    L13:
        int r107 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.fix_attach_preview_over_permission") == true) goto L16;
    L20:
        b r114 = new b(this, r103, r112, r101, r102, r100);
        w85.a.C8081a r108 = new w85.a.C8081a();
        r108.f558639a = true;
        if (r112 == null) goto L23;
        String r109 = r112.getAttachmentToken();
    L24:
        r108.f558643e = r109;
        r108.f558640b = DownloadRequestInfo.DownloadType.COVER;
        r108.f558649k = new DownloadRequestInfo.b(1280, 1280, "near", false);
        r108.f558650l = 0;
        r108.f558648j = r114;
        if (r112 == null) goto L27;
        String r115 = r112.getExtra();
    L28:
        r108.f558651m = r115;
        r108.f558645g = "bitable_image";
        ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).d(new w85.a(r108));
        goto L29
    L27:
        r115 = null;
        goto L28
    L23:
        r109 = null;
        goto L24
    L16:
        if (com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.f.a(this.f208853b.getToken()) == true) goto L20;
    L5:
        r105 = null;
        goto L7
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
        tt5.a.h("RecordPageCoverAdapter", "destroyItem position : " + r101);
        y r103 = (y) r102;
        r100.removeView(r103.f208924a);
        r103.f208924a = null;
        r103.f208925b = null;
        return;
    L5:
        tt5.a.h("RecordPageCoverAdapter", "destroyItem container is null or object type is illegal");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        super.setPrimaryItem(r100, r101, r102);
    }
}
