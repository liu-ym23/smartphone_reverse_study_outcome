package com.bytedance.ee.bear.more.itemv2;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.j0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.ui.m;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kd5.b2;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import oj5.d;
import oj5.e;
import oj5.f;
import rj5.n;
import rj5.o;
import rj5.p;
import rj5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ManualCacheItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String TAG = "ManualCacheItemV2";
    private final long K_INTERNEL_CLICK;
    private long lastClickTime;
    private Activity mActivity;
    private Disposable mDisposable;
    private final a mMoreManualOfflineCallback;

    public static class a implements c0.b {
        public final WeakReference<ManualCacheItemV2> a;

        public a(ManualCacheItemV2 r2) {
            this.a = new WeakReference(r2);
        }

        public final void a(final boolean r2) {
            m.a(new p(this, r2));
        }

        public final void b(final Document r8, final long r9, final b2 r11) {
            m.a(new q(this, r9, r11, r8));
        }
    }

    public static /* synthetic */ void a(ManualCacheItemV2 r0) {
        r0.lambda$onClick$0();
    }

    public static /* synthetic */ void b(ManualCacheItemV2 r0, Document r1, Throwable r2) {
        r0.lambda$onClick$2(r1, r2);
    }

    public static /* synthetic */ void c(ManualCacheItemV2 r0, Document r1, Boolean r2) {
        r0.lambda$onClick$1(r1, r2);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    private void dismissMenu() {
        Disposable r0 = this.mDisposable;     // Catch: Exception -> L9
        if (r0 != null) goto L5;
    L7:
        getHost().a();     // Catch: Exception -> L9
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.mDisposable.dispose();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        tt5.a.f(TAG, e, false);
    }

    private /* synthetic */ void lambda$onClick$0() {
        Activity r0 = this.mActivity;
        Toast.showSuccessText(r0, r0.getString(2131887811), 0);
        dismissMenu();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.MANUAL_CACHE.getId();
    }

    public Document getManualOfflineDocument() {
        Document r0 = new Document();
        if (getMoreInfo() == null) goto L12;
        r0.d = com.bytedance.ee.bear.more.q.a(getMoreInfo());
        r0.b = com.bytedance.ee.bear.more.q.getType(getMoreInfo());
        r0.a = getMoreInfo().getTitle();
        r0.j = getMoreInfo().getCreateTime();
        r0.F = getMoreInfo().b();
        r0.e = getMoreInfo().t();
        r0.f = getMoreInfo().a();
        r0.V = String.valueOf(SystemClock.uptimeMillis());
        r0.j = getMoreInfo().getCreateTime();
        String r1 = ((oj5.a) getMoreInfo()).I;
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r0.i = r1;
        if (e.a(getMoreInfo()) == false) goto L12;
        r0.G1 = getMoreInfo().getToken();
        r0.y1 = getMoreInfo().getType();
        d r2 = ((oj5.a) getMoreInfo()).H;
        if (r2 == null) goto L12;
        r0.O = r2.toString();
    L12:
        return r0;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        if (isValidClick() == true) goto L6;
        tt5.a.k(TAG, "click manual cache menu unValidClick, just ignore this action.");
        return;
    L6:
        c r1 = getMoreInfo();
        if (r1 != null) goto L10;
        tt5.a.d(TAG, "onClick, but more info == null");
        return;
    L10:
        String r2 = getManualOfflineToken(r1);
        int r3 = getManualOfflineType(r1);
        final Document r4 = getManualOfflineDocument();
        if (r1.j() == false) goto L13;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).A(r4);
        m.a(new rj5.m(this));
    L15:
        if ((r1 instanceof oj5.a) == true) goto L17;
        return;
    L17:
        if (isFromSpace() == false) goto L19;
        String r5 = "none";
    L20:
        String r10 = r5;
        Bundle r6 = getHost().getHostFragment().getArguments();
        String r7 = r1.getToken();
        int r8 = r1.getType();
        String r9 = r1.b();
        if (r1.j() == false) goto L23;
        String r11 = "turn_off_offline";
    L24:
        com.bytedance.ee.bear.more.c.c(new i(r6, r7, r8, false, r9, r11, r10, "", "", r1 instanceof f, ((oj5.a) r1).k, r1.H(), r1.isOwner(), r1.L()));
        return;
    L23:
        r11 = "turn_on_offline";
        goto L24
    L19:
        r5 = "ccm_docs_page_view";
        goto L20
    L13:
        ((zk5.a) org.koin.java.a.a(zk5.a.class)).a(r3, r2, OperationName.OPERATION_OFFLINE_AVAILABLE);
        this.mDisposable = ((rc5.a) org.koin.java.a.a(rc5.a.class)).L(r2).subscribe(new n(this, r4), new o(this, r4));
        goto L15
    }

    private boolean isFromSpace() {
        Bundle r0 = getHost().getHostFragment().getArguments();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getInt("more_scene", -1) != 0) goto L7;
        return true;
    }

    private boolean isManualOffline() {
        if (getMoreInfo() != null) goto L5;
    L7:
        return false;
    L5:
        if (getMoreInfo().j() == false) goto L7;
        return true;
    }

    private boolean isValidClick() {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.lastClickTime) >= 800) goto L6;
        return false;
    L6:
        this.lastClickTime = r0;
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        if (isManualOffline() == false) goto L5;
        return 2131254034;
    L5:
        return 2131255245;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        if (isManualOffline() == false) goto L5;
        int r0 = 2131887798;
    L7:
        return getString(r0);
    L5:
        r0 = 2131887795;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L13;
        oj5.a r0 = (oj5.a) getMoreInfo();
        if (r0.p == false) goto L8;
        return false;
    L8:
        if (((rc5.a) org.koin.java.a.a(rc5.a.class)).z(r0.getType()) == true) goto L10;
        return false;
    L10:
        if (com.bytedance.ee.bear.more.q.b(r0) == true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public ManualCacheItemV2(Activity r3) {
        this.mMoreManualOfflineCallback = new a(this);
        this.K_INTERNEL_CLICK = 800;
        this.mActivity = r3;
    }

    public static /* synthetic */ Activity access$000(ManualCacheItemV2 r0) {
        return r0.mActivity;
    }

    public static /* synthetic */ void access$100(ManualCacheItemV2 r0) {
        r0.dismissMenu();
    }

    private void doManualOffline(Document r10) {
        sj5.b r0 = getHost();
        String r1 = DocumentType.VALUE_DRIVE;
        if (r0 != null) goto L5;
    L9:
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).U(new j0(true, false, r1, true, r10, this.mMoreManualOfflineCallback));
        return;
    L5:
        if (getHost().getHostFragment() == null) goto L9;
        if (getHost().getHostFragment().getArguments() == null) goto L9;
        r1 = getHost().getHostFragment().getArguments().getString("module", DocumentType.VALUE_DRIVE);
        goto L9
    }

    private String getManualOfflineToken(c r2) {
        if (e.a(r2) == false) goto L10;
        if (e.a(r2) == false) goto L7;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.WikiMoreInfo");
        return ((f) r2).O;
    L7:
        return "";
    L10:
        return r2.getToken();
    }

    private int getManualOfflineType(c r2) {
        if (e.a(r2) == false) goto L7;
        return 16;
    L7:
        return r2.getType();
    }

    private void lambda$onClick$1(Document r1, Boolean r2) throws Exception {
        r1.w = r2.booleanValue();
        doManualOffline(r1);
    }

    private /* synthetic */ void lambda$onClick$2(Document r3, Throwable r4) throws Exception {
        tt5.a.d(TAG, "throwable = " + r4);
        doManualOffline(r3);
    }
}
