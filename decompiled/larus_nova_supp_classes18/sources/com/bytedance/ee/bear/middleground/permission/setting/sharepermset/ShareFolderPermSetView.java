package com.bytedance.ee.bear.middleground.permission.setting.sharepermset;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.widgets.t;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mi5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/sharepermset/ShareFolderPermSetView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/IFolderPermSetInfo;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/FolderPermSetInfo;", "shareParams", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "hasPullPerm", "", "setShareParams", "", "failToFetchPerm", "init", "setFolderPermSetInfo", "folderPermSetInfo", "onClickView", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFolderPermSetView extends RelativeLayout implements ej5.b {
    public FolderPermSetInfo a;
    public ShareParams b;
    public boolean c;

    public static final class a extends t {
        public final /* synthetic */ ShareFolderPermSetView c;

        public a(ShareFolderPermSetView r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            Toast.showFailureText(this.c.getContext(), this.c.getContext().getString(2131888342));
        }
    }

    public static final class b extends t {
        public final /* synthetic */ ShareFolderPermSetView c;

        public b(ShareFolderPermSetView r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r8) {
            ShareFolderPermSetView r9 = this.c;
            FolderPermSetInfo r0 = r9.a;
            if (r0 != null) goto L5;
            r0 = new FolderPermSetInfo(0, null, null, 8191);
        L5:
            HashMap r2 = new HashMap();
            String r3 = r0.i;
            String r4 = "";
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            int r5 = h.a;
            h.a(r9.b, r3, r9.getContext(), null, null);
            int r1 = oi5.h.a;
            String r6 = r0.j.a.getReportJson();
            IFolderPublicPermission r7 = r0.j.b;
            if ((r7 instanceof FolderPublicPermissionV3) == false) goto L11;
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3");
            r4 = ((FolderPublicPermissionV3) r7).reportJson();
        L11:
            oi5.h.a(r2, r6, r4, r9.b);
        }
    }

    @Override // ej5.b
    public final void s() {
        if (this.c == false) goto L5;
        return;
    L5:
        setOnClickListener(new a(this));
    }

    public ShareFolderPermSetView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // ej5.b
    public void setFolderPermSetInfo(FolderPermSetInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "folderPermSetInfo");
        this.a = r2;
        setAlpha(1.0f);
        this.c = true;
        if (r2.j.a.canManagePermissionMeta(r2.a()) == false) goto L5;
        int r3 = 0;
    L6:
        setVisibility(r3);
        setOnClickListener(new b(this));
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setShareParams(ShareParams r2) {
        Intrinsics.checkNotNullParameter(r2, "shareParams");
        this.b = r2;
        if (r2.isOwner() == false) goto L5;
        int r3 = 0;
    L6:
        setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public ShareFolderPermSetView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public ShareFolderPermSetView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131564192, this);
        setAlpha(0.3f);
    }
}
