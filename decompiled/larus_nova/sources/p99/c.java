package p99;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.feedback.api.model.FlowDislikePanelConfig;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.platform.model.NotificationType;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import hq9.n3;
import hq9.q3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import q99.i;
import q99.k;

/* JADX INFO: loaded from: classes27.dex */
public abstract class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n99.a f528321a;

    public static final class a {
    }

    public static final class b implements q3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f528322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o99.a f528323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q99.e f528324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f528325d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ i f528326e;

        @Override // hq9.q3
        public final void c() {
        }

        @Override // hq9.q3
        public final void a() {
            FLogger.f375446a.i("BaseFeedbackManager", "[showPopup.onDialogCloseByUserMoveUp]:");
            o99.a r100 = this.f528323b;
            if (r100 == null) goto L6;
            r100.i();
            return;
        }

        @Override // hq9.q3
        public final void b(boolean r100) {
            FLogger.f375446a.i("BaseFeedbackManager", "[showPopup.onFeedbackClick]: isLike = " + r100 + ", feedbackClicked = " + this.f528322a);
            if (this.f528322a == false) goto L5;
            return;
        L5:
            this.f528322a = true;
            o99.a r101 = this.f528323b;
            if (r101 == null) goto L8;
            r101.j(this.f528324c, r100);
        L8:
            if (r100 == false) goto L10;
            this.f528325d.c(this.f528324c, this.f528326e);
            return;
        L10:
            this.f528325d.b(this.f528324c, this.f528326e);
        }

        public b(o99.a r100, q99.e r101, c r102, i r103) {
            this.f528323b = r100;
            this.f528324c = r101;
            this.f528325d = r102;
            this.f528326e = r103;
        }
    }

    static {
    }

    public void d(q99.e r100, i r101, q99.a r102) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r101, "host");
        Intrinsics.checkNotNullParameter(r102, "result");
    }

    public c(n99.a r100) {
        Intrinsics.checkNotNullParameter(r100, "gateway");
        this.f528321a = r100;
    }

    public void b(final q99.e r210, final i r211) {
        Intrinsics.checkNotNullParameter(r210, "delivery");
        Intrinsics.checkNotNullParameter(r211, "host");
        Intrinsics.checkNotNullParameter(r210, "delivery");
        Intrinsics.checkNotNullParameter(r211, "host");
        Function0<LifecycleOwner> r100 = r211.f532159h;
        if (r100 == null) goto L5;
        LifecycleOwner r110 = r100.invoke();
    L6:
        if (r110 == null) goto L73;
        Function0<FragmentManager> r101 = r211.f532160i;
        if (r101 == null) goto L11;
        FragmentManager r111 = r101.invoke();
    L12:
        if (r111 == null) goto L74;
        final q99.d r112 = r210.f532149f;
        if (r112 == null) goto L75;
        final o99.a r113 = r211.f532168q;
        List<q99.b> r102 = r112.a();
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r103 = ((ArrayList) r102).iterator();
    L19:
        if (r103.hasNext() == false) goto L22;
        q99.b r104 = (q99.b) r103.next();
        r114.add(new FeedbackMeta(MsgFeedbackType.MsgFeedbackTypeDislike.value, r104.f532142a, r104.f532143b));
        goto L19
    L22:
        if (r114.isEmpty() == true) goto L76;
        String r105 = r112.b();
        if (r105 != null) goto L27;
        r105 = "";
    L27:
        final String r106 = "flow_feedback_dislike_panel_".concat(r105);
        Fragment r107 = r111.findFragmentByTag(r106);
        if ((r107 instanceof DialogFragment) == false) goto L30;
        DialogFragment r108 = (DialogFragment) r107;
    L31:
        if (r108 != null) goto L67;
        final FragmentManager r109 = r111;
        r111.setFragmentResultListener(r106, r110, new p99.b(r112, r113, r210, r109, r106, this, r211));
        FlowFeedbackServiceDelegate r115 = FlowFeedbackServiceDelegate.f343027a;
        ArrayList r116 = new ArrayList(r114);
        String r117 = r112.g();
        if (r117 != null) goto L41;
        String r212 = "";
    L42:
        Bundle r118 = new Bundle();
        String r119 = r210.f532145b;
        if (r119 != null) goto L45;
        r119 = r112.e();
    L45:
        r118.putString(MusicAppletPage.KEY_MESSAGE_ID, r119);
        r118.putString("message_log_id", r210.f532148e);
        r118.putBoolean("disable_copy_button", r211.f532164m);
        r118.putBoolean("is_multiple_selection", true);
        if (r113 == null) goto L51;
        Bundle r120 = r113.b(r118);
        if (r120 == null) goto L51;
        Bundle r213 = r120;
    L52:
        DialogFragment r121 = r115.d(new FlowDislikePanelConfig(r106, r116, r212, r213, null, false, false));
        if ((r121 instanceof Fragment) == false) goto L55;
        DialogFragment r122 = r121;
    L56:
        LandscapeRestrictionOperation r123 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r122, r106, r123);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r111, r122, r123) == false) goto L65;
    L61:
        if (r113 == null) goto L72;
        r113.d();
        return;
    L72:
        return;
    L65:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L64
    L60:
        r121.show(r111, r106);
        goto L61
    L55:
        r122 = null;
    L51:
        r213 = r118;
        goto L52
    L41:
        r212 = r117;
        goto L42
    L67:
        r108.dismissAllowingStateLoss();     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r124 = DialogFragmentLancet.sLastShowStack;
        if (r124 == null) goto L70;
        com.bytedance.crash.d.d(r124, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L70:
        return;
    L30:
        r108 = null;
        goto L31
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L11:
        r111 = null;
        goto L12
    L73:
        return;
    L5:
        r110 = null;
        goto L6
    }

    public void c(q99.e r110, i r111) {
        Intrinsics.checkNotNullParameter(r110, "delivery");
        Intrinsics.checkNotNullParameter(r111, "host");
        q99.d r100 = r110.f532149f;
        if (r100 == null) goto L5;
        String r101 = r100.b();
    L6:
        String r102 = "";
        if (r101 != null) goto L9;
        String r103 = "";
    L10:
        q99.d r104 = r110.f532149f;
        if (r104 == null) goto L13;
        Integer r105 = r104.c();
    L14:
        int r106 = MsgFeedbackType.MsgFeedbackTypeLike.value;
        Map r107 = MapsKt.createMapBuilder();
        String r112 = r110.f532145b;
        if (r112 == null) goto L18;
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r112);
    L18:
        if (r111.a() == null) goto L24;
        String r113 = r111.a();
        if (r113 == null) goto L23;
        r102 = r113;
    L23:
        r107.put("section_id", r102);
    L24:
        String r114 = r111.f532155d;
        if (r114 == null) goto L27;
        r107.put("call_id", r114);
    L27:
        r107.put("click_from", "banner_action");
        k r115 = new k(r105, r103, r106, MapsKt.build(r107), 24);
        Intrinsics.checkNotNullParameter(r115, "request");
        this.f528321a.b(r115, null);
        return;
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = r101;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [p99.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // p99.e
    public void query(q99.c r100, final o99.c r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f528321a.a(r100, new p99.a(r101));
    }

    public final n3 a(q99.d r210, String r211, q99.e r212, i r213, String r310, List<String> r311, o99.a r312) {
        Intrinsics.checkNotNullParameter(r210, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r211, "avatarUrl");
        Intrinsics.checkNotNullParameter(r212, "delivery");
        Intrinsics.checkNotNullParameter(r213, "host");
        Intrinsics.checkNotNullParameter(r310, "notificationBusiness");
        String r100 = r210.e();
        String r101 = r210.i();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        n3 r102 = new n3(r100, r211, r101, null, NotificationType.FEEDBACK, 0, r310, r311, new b(r312, r212, this, r213), null, null, null, null, null, false, null, false, null, 1047636);
        if (r312 == null) goto L12;
        n3 r103 = r312.f(r102);
        if (r103 != null) goto L11;
        return r102;
    L11:
        return r103;
    L12:
        return r102;
    }
}
