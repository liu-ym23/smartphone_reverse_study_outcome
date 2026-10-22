package com.bytedance.ee.bear.imageviewer.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import cj5.c;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.i;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import com.bytedance.ee.util.info.AppInfoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0002./B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001bH\u0002J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\b\u0010+\u001a\u00020,H\u0002J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/imageviewer/view/ImageViewerShareDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "<init>", "()V", "panelSession", "", "getPanelSession", "()Ljava/lang/String;", "shareActionListener", "Lcom/bytedance/ee/bear/imageviewer/view/ImageViewerShareDialogFragment$ShareActionListener;", "externalShareView", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "supportExternalApp", "", "showDownload", "showLark", "showMore", "downloadTextResId", "", "setShareActionListener", "listener", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDestroyView", "initArguments", "initShareView", "rootView", "getShareItems", "", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "buildFallbackShareItems", "ShareActionListener", "Companion", "features-image-viewer-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageViewerShareDialogFragment extends BaseBottomSheetDialogFragment implements i {
    public final String k;
    public b l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final km5.a da0() {
        ArrayList r8 = new ArrayList();
        if (this.n == true) goto L6;
        r8.add(Integer.valueOf(ShareType.Download.ordinal()));
    L6:
        if (this.o == true) goto L9;
        r8.add(Integer.valueOf(ShareType.Lark.ordinal()));
    L9:
        if (this.p == true) goto L12;
        r8.add(Integer.valueOf(ShareType.More.ordinal()));
    L12:
        if (this.m == true) goto L14;
        r8.add(Integer.valueOf(ShareType.Wechat.ordinal()));
        r8.add(Integer.valueOf(ShareType.WechatMoments.ordinal()));
        r8.add(Integer.valueOf(ShareType.QQ.ordinal()));
        r8.add(Integer.valueOf(ShareType.Weibo.ordinal()));
    L14:
        Bundle r1 = getArguments();
        int r3 = 0;
        if (r1 == null) goto L17;
        r3 = r1.getInt("arg_doc_type", 0);
    L17:
        Bundle r2 = getArguments();
        if (r2 == null) goto L20;
        String r4 = r2.getString("arg_doc_token");
    L22:
        return new km5.a(0, r3, r4, false, false, null, r8, null, false, false, false, false, null, null, false, false, ShareScene.EXPORT_IMAGE, 49152);
    L20:
        r4 = null;
        goto L22
    }

    public ImageViewerShareDialogFragment() {
        this.k = String.valueOf(hashCode());
        this.n = true;
        this.p = true;
        this.q = 2131887679;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        ((c) org.koin.java.a.c(c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, da0());
    }

    public final String getPanelSession() {
        return this.k;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Bundle r10 = getArguments();
        if (r10 == null) goto L5;
        this.m = r10.getBoolean("arg_support_external_app", false);
        this.n = r10.getBoolean("arg_show_download", true);
        this.o = r10.getBoolean("arg_show_lark", !AppInfoUtils.e().booleanValue());
        this.p = r10.getBoolean("arg_show_more", true);
        this.q = r10.getInt("arg_download_text_res_id", 2131887679);
    L5:
        ExternalShareView r11 = (ExternalShareView) r8.findViewById(2131375109);
        if (r11 != null) goto L34;
    L32:
        ((c) org.koin.java.a.c(c.class, null, null, 6)).H9(this, SharePanelState.SHOWING, da0());
        return;
    L34:
        List r0 = ((c) org.koin.java.a.c(c.class, null, null, 6)).getProvider().a(da0());     // Catch: Throwable -> L9
    L11:
        List r1 = r0;
        boolean r2 = r1.isEmpty();
        Object r3 = r1;
        if (r2 == false) goto L25;
        ArrayList r4 = new ArrayList();
        if (this.n == false) goto L17;
        ShareItemUtil r5 = ShareItemUtil.a;
        ShareType r6 = ShareType.Download;
        ShareState r7 = ShareState.SHOW;
        r5.getClass();
        r4.add(ShareItemUtil.a(r6, r7));
    L17:
        if (this.o == false) goto L20;
        ShareItemUtil r12 = ShareItemUtil.a;
        ShareType r13 = ShareType.Lark;
        ShareState r14 = ShareState.SHOW;
        r12.getClass();
        r4.add(ShareItemUtil.a(r13, r14));
    L20:
        if (this.m == false) goto L22;
        ShareItemUtil r16 = ShareItemUtil.a;
        ShareType r17 = ShareType.Wechat;
        ShareState r18 = ShareState.SHOW;
        r16.getClass();
        r4.add(ShareItemUtil.a(r17, r18));
        r4.add(ShareItemUtil.a(ShareType.WechatMoments, r18));
        r4.add(ShareItemUtil.a(ShareType.QQ, r18));
        r4.add(ShareItemUtil.a(ShareType.Weibo, r18));
    L22:
        r3 = r4;
        if (this.p == false) goto L25;
        ShareItemUtil r19 = ShareItemUtil.a;
        ShareType r20 = ShareType.More;
        ShareState r21 = ShareState.SHOW;
        r19.getClass();
        r4.add(ShareItemUtil.a(r20, r21));
        r3 = r4;
    L25:
        int r22 = ContextCompat.getColor(requireContext(), 2131100549);
        List r23 = (List) r3;
        Iterator r24 = r23.iterator();
    L27:
        if (r24.hasNext() == false) goto L31;
        ShareItemModel r26 = (ShareItemModel) r24.next();
        r26.setShareItemBackground(r22);
        if (r26.getType() != ShareType.Download) goto L27;
        r26.setDescription(getString(this.q));
        goto L27
    L31:
        r11.b(r23);
        r11.setOnShareItemClickListener(new com.bytedance.ee.bear.imageviewer.view.a(this));
    L9:
        th = move-exception;
        tt5.a.e("ImageViewerShareDialog", "getShareItems failed", th, false);
        r0 = CollectionsKt.emptyList();
        goto L11
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561538, r3, false);
    }
}
