package com.bytedance.ee.bear.drive.biz.importfile;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;
import com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.io.FileUtils;
import i55.c;
import i55.d;
import i55.f;
import i55.i;
import jg5.e;
import o55.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveImportFileFragment extends AbsMvpFragment<i> implements b {
    public static final /* synthetic */ int r = 0;
    public BaseTitleBar g;
    public View h;
    public SpaceEmptyState i;
    public c j;
    public d k;
    public LiveData<ConnectionService.NetworkState> l;
    public j m;
    public ImportFileEntity n;
    public boolean o;
    public ImportFailedType p;
    public long q;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImportFailedType.values().length];
            a = r0;
            r0[ImportFailedType.FailedNoPermisson.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L72:
            a[ImportFailedType.FailedType.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L52:
            a[ImportFailedType.FailedSize.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L66:
            a[ImportFailedType.FailedCanRetry.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L74:
            a[ImportFailedType.FailedOverLimitCount.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L54:
            a[ImportFailedType.FailedEncrypt.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L58:
            a[ImportFailedType.FailedNoNet.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L86:
            a[ImportFailedType.FailedImportBlockNumberOverLimit.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            a[ImportFailedType.FailedImportBlockHierarchyOverLimit.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L78:
            a[ImportFailedType.FailedImportBlockStorageOverLimit.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L82:
            a[ImportFailedType.FailedNotExist.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L62:
            a[ImportFailedType.FailedEmptyFile.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L70:
            a[ImportFailedType.FailedMigateBrand.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L50:
            a[ImportFailedType.FailedMigateDoc.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L56:
            a[ImportFailedType.FailedDlpError.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L84:
            a[ImportFailedType.ImDlpFail.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L46:
            a[ImportFailedType.ImDlpProgress.ordinal()] = 17;     // Catch: NoSuchFieldError -> L41
        L76:
            a[ImportFailedType.EncryptFile.ordinal()] = 18;     // Catch: NoSuchFieldError -> L42
        L80:
            a[ImportFailedType.FailedQuotaLimit.ordinal()] = 19;     // Catch: NoSuchFieldError -> L43
        L60:
            a[ImportFailedType.FailedImportDriveFileEncrypted.ordinal()] = 20;     // Catch: NoSuchFieldError -> L44
        L68:
            a[ImportFailedType.FailedCanContactSupport.ordinal()] = 21;     // Catch: NoSuchFieldError -> L45
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final int getContentViewLayoutId() {
        return 2131560200;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initActions(View r1) {
    }

    @Override // o55.b
    public final void W40() {
        tt5.a.h("DriveImportFileFragment", "showGenerating");
        this.h.setVisibility(0);
        this.i.setVisibility(8);
    }

    public final void W90() {
    L6:
        e = move-exception;
        tt5.a.f("DriveImportFileFragment", e, false);
        return;
    L3:
        if (getArguments() == null) goto L11;
        this.n = (ImportFileEntity) getArguments().getParcelable("extra_drive_file_open_entity");     // Catch: Exception -> L6
        return;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initData() {
        W90();
        ((i) this.f).a(this.n);
        j r0 = j.a.a;
        this.m = r0;
        this.l = r0.a();
        if (this.n != null) goto L6;
        y();
        return;
    }

    public final void y() {
        if (getActivity() == null) goto L6;
        getActivity().finish();
        return;
    }

    public DriveImportFileFragment() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override // o55.b
    public final void Cm(String r2) {
        ((h) org.koin.java.a.a(h.class)).u5(r2);
        y();
    }

    @Override // o55.b
    public final void Fh(long r4) {
        this.q = r4;
        this.h.setVisibility(8);
        this.i.setVisibility(0);
        if (r4 < 0) goto L5;
        String r5 = FileUtils.r(r4);
    L6:
        this.i.setDesc(r5);
        return;
    L5:
        r5 = "";
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final m75.d V90(Context r9) {
        W90();
        ImportFileEntity r0 = this.n;
        if (r0 == null) goto L10;
        if (r0.d == false) goto L10;
        if (r0.c == null) goto L10;
        FragmentActivity r10 = (FragmentActivity) r9;
        return new j55.a(r10, this.n.e, new com.bytedance.ee.bear.drive.biz.importfile.im.data.a((NetService) org.koin.java.a.a(NetService.class), this.n.c.get("messageId"), this.n.c.get("sourceId"), this.n.a));
    L10:
        return new k55.h((FragmentActivity) r9);
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        if (r3 == null) goto L13;
        this.o = r3.getBoolean("error_page_state");
        this.p = (ImportFailedType) r3.getSerializable("failed_type");
        this.q = r3.getLong("file_size");
        ImportFailedType r4 = this.p;
        if (r4 != null) goto L7;
        return;
    L7:
        if (this.o == false) goto L10;
        Do(r4, -1);
    L10:
        if (this.p != ImportFailedType.FailedSize) goto L15;
        Fh(this.q);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final void onSaveInstanceState(Bundle r4) {
        super.onSaveInstanceState(r4);
        r4.putBoolean("error_page_state", this.o);
        r4.putSerializable("failed_type", this.p);
        r4.putLong("file_size", this.q);
    }

    @Override // o55.b
    public final void showToast(String r3) {
        Toast.showText(eu5.b.a, r3, 1);
    }

    /* JADX WARN: Type inference failed for: r1v63, types: [android.view.View$OnClickListener, i55.a] */
    @Override // o55.b
    public final void Do(ImportFailedType r23, int r24) {
        tt5.a.h("DriveImportFileFragment", "showFailed failedType = " + r23 + "  errCode = " + r24);
        this.h.setVisibility(8);
        this.p = r23;
        int r3 = f.a(this.n.b.toLowerCase());
        this.i.setPadding(y9c.d.a(0), 0, y9c.d.a(0), 0);
        String r13 = "";
        View.OnClickListener r14 = null;
        switch(a.a[r23.ordinal()]) {
            case 1: goto L52;
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L44;
            case 9: goto L43;
            case 10: goto L42;
            case 11: goto L41;
            case 12: goto L40;
            case 13: goto L39;
            case 14: goto L38;
            case 15: goto L31;
            case 16: goto L24;
            case 17: goto L18;
            case 18: goto L17;
            case 19: goto L5;
            case 20: goto L16;
            default: goto L4;
        };
    L4:
        String r1 = getString(2131888412);
        String r2 = getString(2131888408);
        d r4 = this.k;
    L55:
        r14 = r4;
        String r5 = r2;
    L56:
        String r6 = "";
    L57:
        String r7 = r1;
        r13 = r6;
    L58:
        String r8 = r5;
        View.OnClickListener r9 = r14;
        boolean r10 = true;
    L59:
        this.i.setTitle(r7);
        this.i.setDesc(r13);
        this.i.setPrimaryText(r8);
        this.i.setPrimaryClickListener(r9);
        this.i.setPrimaryActionEnabled(r10);
        this.i.setVisibility(0);
        this.o = true;
        return;
    L5:
        t r16 = (t) org.koin.java.a.a(t.class);
        ?? r11 = new i55.a(this);
        if (r16.k(r24) == false) goto L9;
        r16.i(getActivity(), null, null, false, "", r11);
        goto L16
    L9:
        if (r16.s(r24) == false) goto L12;
        r16.i(getActivity(), null, null, true, "", r11);
        goto L16
    L12:
        if (r16.q(r24) == false) goto L14;
    L15:
        r16.n(getActivity(), r24, r11);
        goto L16
    L14:
        if (r16.o(r24) == true) goto L15;
    L16:
        r1 = getString(2131889481);
    L53:
        r6 = "";
        r5 = r6;
        goto L57
    L17:
        String r12 = getString(2131889700);
        this.i.setImageRes(2131232553);
        this.i.setPadding(y9c.d.a(64), 0, y9c.d.a(64), 0);
        r5 = "";
        r13 = r12;
        r7 = r5;
        goto L58
    L18:
        if (r3 != 101) goto L20;
        r1 = getString(2131889529);
        goto L53
    L20:
        if (r3 != 102) goto L22;
        r1 = getString(2131889532);
        goto L53
    L22:
        if (r3 != 103) goto L30;
        r1 = getString(2131889530);
    L30:
        r7 = "";
        r5 = r7;
        goto L58
    L24:
        if (r3 != 101) goto L26;
        r1 = getString(2131889528);
        goto L53
    L26:
        if (r3 != 102) goto L28;
        r1 = getString(2131889531);
        goto L53
    L28:
        if (r3 != 103) goto L30;
        r1 = getString(2131889527);
        goto L53
    L31:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L34;
        s55.a r17 = s55.a.a;
        s55.a.f(r24, "EXPORT", "", eu5.b.a());
    L37:
        r1 = getString(2131888412);
        r2 = getString(2131888408);
        r4 = this.k;
        goto L55
    L34:
        String r18 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.d.class)).f("", "CCM_EXPORT", r24);
        if (TextUtils.isEmpty(r18) == true) goto L37;
        showToast(r18);
        goto L37
    L38:
        r1 = getString(2131887344);
        goto L53
    L39:
        r1 = getString(2131887345);
        goto L53
    L40:
        r1 = getString(2131887552);
        goto L53
    L41:
        r1 = getString(2131887157);
        goto L53
    L42:
        r1 = getString(2131888411);
        r6 = getString(2131887154);
    L45:
        r5 = "";
        goto L57
    L43:
        r1 = getString(2131888411);
        r6 = getString(2131887153);
        goto L45
    L44:
        r1 = getString(2131888411);
        r6 = getString(2131887152);
        goto L45
    L46:
        r7 = getString(2131887567);
        r8 = getString(2131888445);
        r9 = this.j;
        r10 = false;
        goto L59
    L47:
        r1 = getString(2131887158);
        goto L53
    L48:
        r1 = getString(2131887156);
        goto L53
    L49:
        r1 = getString(2131887555);
        r5 = getString(2131888445);
        c r19 = this.j;
        ((t) org.koin.java.a.a(t.class)).l(r24, getActivity());
        r14 = r19;
        goto L56
    L50:
        r1 = ((i) this.f).c();
        goto L53
    L51:
        r1 = getString(2131888410);
        goto L53
    L52:
        r1 = getString(2131887155);
        goto L53
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [i55.c] */
    /* JADX WARN: Type inference failed for: r4v4, types: [i55.d] */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initViews(View r4, Bundle r5) {
        if (this.n != null) goto L6;
        y();
        return;
    L6:
        BaseTitleBar r0 = r4.findViewById(2131379479);
        this.g = r0;
        r0.setDividerVisible(false);
        this.g.setLeftClickListener(new i55.b(this));
        this.g.setRightVisible(false);
        this.g.setTitle(this.n.b);
        this.h = r4.findViewById(2131375187);
        this.i = r4.findViewById(2131391810);
        this.j = new c(this);
        this.k = new d(this);
        this.l.observe(this, new i55.e(this));
        ((i) this.f).g(this.l);
        if (r5 != null) goto L10;
        ((i) this.f).d();
        return;
    }
}
