package com.bytedance.ee.bear.middleground.permission.setting.sharepermset;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mi5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020!H\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u001fH\u0002R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/sharepermset/SharePermSetView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/IDocPermSetInfo;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sharePermSetEntranceIconFromXml", "Landroid/widget/ImageView;", "getSharePermSetEntranceIconFromXml", "()Landroid/widget/ImageView;", "setSharePermSetEntranceIconFromXml", "(Landroid/widget/ImageView;)V", ResourceData.KEY_URL, "", ResourceData.KEY_TOKEN, ResourceData.KEY_TYPE, "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "publicPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "module", "shareParams", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "init", "", "hasPullPerm", "", "setShareParams", "setDocPermSetInfo", "docPermSetInfo", "setPublicPermission", "setDivider", "show", "makePermInfoComple", "isDisableView", "failToFetchPerm", "throwable", "", "onClickView", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharePermSetView extends RelativeLayout implements ej5.a {
    public static final /* synthetic */ int f = 0;
    public ImageView a;
    public DocPermSetInfo b;
    public IDocPublicPermission c;
    public ShareParams d;
    public boolean e;

    public static final class a extends t {
        public final /* synthetic */ SharePermSetView c;

        public a(SharePermSetView r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            Toast.showFailureText(this.c.getContext(), this.c.getContext().getString(2131888342));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SharePermSetView a;

        public b(SharePermSetView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Toast.showText(this.a.getContext(), this.a.getContext().getString(2131889300));
        }
    }

    public static final class c extends t {
        public final /* synthetic */ SharePermSetView c;

        public c(SharePermSetView r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r6) {
            SharePermSetView r7 = this.c;
            int r0 = SharePermSetView.f;
            r7.getClass();
            HashMap r1 = new HashMap();
            DocPermSetInfo r2 = r7.b;
            if (r2 == null) goto L6;
            String r3 = r2.e.getCreatorTenantId();
            if (r3 == null) goto L6;
        L7:
            int r4 = h.a;
            String r5 = null;
            h.a(r7.d, r3, r7.getContext(), null, null);
            int r8 = oi5.h.a;
            DocPermSetInfo r9 = r7.b;
            if (r9 == null) goto L12;
            IDocUserPermission r10 = r9.f.a;
            if (r10 == null) goto L12;
            String r11 = r10.getReportJson();
        L13:
            DocPermSetInfo r12 = r7.b;
            if (r12 == null) goto L18;
            IDocPublicPermission r13 = r12.f.b;
            if (r13 == null) goto L18;
            r5 = r13.getReportJson();
        L18:
            oi5.h.a(r1, r11, r5, r7.d);
            return;
        L12:
            r11 = null;
        L6:
            r3 = "";
            goto L7
        }
    }

    @Override // ej5.a
    public void setDivider(boolean r1) {
    }

    public final boolean a() {
        DocPermSetInfo r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return false;
    L10:
        getSharePermSetEntranceIconFromXml().setVisibility(8);
        setAlpha(0.3f);
        setOnClickListener(new b(this));
        return true;
    L5:
        if (r0.getType() != 44) goto L7;
        r1 = true;
        goto L8
    }

    public final void b() {
        if (this.b != null) goto L5;
        return;
    L5:
        if (this.c != null) goto L8;
        return;
    L8:
        if (a() == false) goto L10;
        return;
    L10:
        DocPermSetInfo r0 = this.b;
        if (r0 == null) goto L15;
        IDocPublicPermission r1 = this.c;
        Intrinsics.checkNotNull(r1);
        r0.c(r1);
        this.e = true;
        return;
    }

    public final ImageView getSharePermSetEntranceIconFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131386055);
        this.a = (ImageView) r0;
    L6:
        return (ImageView) r0;
    }

    public SharePermSetView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // ej5.a
    public final void k2(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if (this.e == false) goto L5;
        return;
    L5:
        setOnClickListener(new a(this));
    }

    @Override // ej5.a
    public void setDocPermSetInfo(DocPermSetInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "docPermSetInfo");
        this.b = r2;
        b();
        if (a() == false) goto L5;
        return;
    L5:
        setAlpha(1.0f);
        setOnClickListener(new c(this));
    }

    @Override // ej5.a
    public void setPublicPermission(IDocPublicPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "publicPerm");
        this.c = r2;
        b();
    }

    public final void setShareParams(ShareParams r2) {
        Intrinsics.checkNotNullParameter(r2, "shareParams");
        r2.getUrl();
        r2.getToken();
        r2.getType();
        r2.getModule();
        this.d = r2;
    }

    public final void setSharePermSetEntranceIconFromXml(ImageView r1) {
        this.a = r1;
    }

    public SharePermSetView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public SharePermSetView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131564192, this);
        setAlpha(0.3f);
    }
}
