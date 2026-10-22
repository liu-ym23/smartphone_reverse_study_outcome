package up8;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.y;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.n;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import va8.s;
import wa8.a0;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f551061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f551062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.bmhome.view.actionbar.edit.c f551063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoroutineScope f551064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f551065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f551066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f551067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ActivityResultLauncher<String> f551068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f551069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s f551070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<b> f551071k;

    public Long c() {
        return null;
    }

    public abstract AbsInstructionWidget e(Context r100);

    public abstract int getType();

    public int i() {
        return 0;
    }

    public boolean j() {
        return false;
    }

    public abstract void k(String r100, boolean r101);

    public void m(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
    }

    public abstract a0 n(String r100);

    public void p(boolean r100) {
    }

    public void q(Integer r100) {
    }

    public final List<b> f() {
        List<b> r100 = this.f551071k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.filterNotNull(r100);
    }

    public final Integer h() {
        u r100 = this.f551062b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f295474a;
    }

    public final void o() {
        com.larus.bmhome.view.actionbar.edit.c r100 = this.f551063c;
        if (r100 == null) goto L71;
        r r101 = r100.getInstructionRebuildStateConf();
        if (r101 == null) goto L71;
        Integer r102 = r101.f295408a;
        Object r103 = null;
        if (r102 != null) goto L10;
    L47:
        List<u> r104 = r101.f295409b;
        if (r104 == null) goto L70;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L51:
        if (r106.hasNext() == false) goto L61;
        Object r107 = r106.next();
        Integer r108 = ((u) r107).f295475b;
        int r109 = getType();
        if (r108 != null) goto L56;
    L58:
        boolean r110 = false;
    L59:
        if (r110 == false) goto L51;
        r105.add(r107);
        goto L51
    L56:
        if (r108.intValue() != r109) goto L58;
        r110 = true;
        goto L59
    L61:
        Iterator r111 = r105.iterator();
    L63:
        if (r111.hasNext() == false) goto L69;
        String r112 = ((u) r111.next()).f295477d;
        if (r112 == null) goto L63;
        if (o0.d(r112) == false) goto L63;
        k(r112, false);
        goto L63
    L69:
        r103 = Unit.INSTANCE;
    L70:
        if (r103 == null) goto L71;
        return;
    L10:
        if (r102.intValue() != 28) goto L47;
        y r113 = r101.f295416i;
        if (r113 == null) goto L70;
        ArrayList<z0> r114 = r113.f295561a;
        if (r114 == null) goto L70;
        z0 r115 = (z0) CollectionsKt.firstOrNull(r114);
        if (r115 == null) goto L70;
        r r116 = r115.f295621q;
        if (r116 == null) goto L21;
        r103 = r116.f295408a;
    L21:
        if (Intrinsics.areEqual(r103, this.f551067g) == false) goto L46;
        r r117 = r115.f295621q;
        if (r117 == null) goto L46;
        List<u> r118 = r117.f295409b;
        if (r118 == null) goto L46;
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r118.iterator();
    L28:
        if (r120.hasNext() == false) goto L38;
        Object r121 = r120.next();
        Integer r122 = ((u) r121).f295475b;
        int r123 = getType();
        if (r122 != null) goto L33;
    L35:
        boolean r124 = false;
    L36:
        if (r124 == false) goto L28;
        r119.add(r121);
        goto L28
    L33:
        if (r122.intValue() != r123) goto L35;
        r124 = true;
        goto L36
    L38:
        Iterator r125 = r119.iterator();
    L40:
        if (r125.hasNext() == false) goto L46;
        String r126 = ((u) r125.next()).f295477d;
        if (r126 == null) goto L40;
        if (o0.d(r126) == false) goto L40;
        k(r126, false);
    L46:
        r103 = Unit.INSTANCE;
    L71:
        com.larus.bmhome.view.actionbar.edit.c r127 = this.f551063c;
        if (r127 == null) goto L136;
        r r128 = r127.getCurrentInstructionUsuallyConfig();
        if (r128 == null) goto L137;
        List<u> r129 = r128.f295409b;
        if (r129 == null) goto L138;
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L79:
        if (r131.hasNext() == false) goto L89;
        Object r132 = r131.next();
        Integer r133 = ((u) r132).f295475b;
        int r134 = getType();
        if (r133 != null) goto L84;
    L86:
        boolean r135 = false;
    L87:
        if (r135 == false) goto L79;
        r130.add(r132);
        goto L79
    L84:
        if (r133.intValue() != r134) goto L86;
        r135 = true;
        goto L87
    L89:
        Iterator r136 = r130.iterator();
    L91:
        if (r136.hasNext() == false) goto L97;
        String r137 = ((u) r136.next()).f295477d;
        if (r137 == null) goto L91;
        if (o0.d(r137) == false) goto L91;
        k(r137, true);
        goto L91
    L97:
        Unit r138 = Unit.INSTANCE;
        return;
    L138:
        return;
    L137:
        return;
    }

    public b() {
        this.f551061a = LazyKt.lazy(new a());
        this.f551067g = 0;
    }

    public static /* synthetic */ void l(b r100, String r101) {
        r100.k(r101, false);
    }

    public final AbsInstructionWidget d(Context r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        s r102 = (s) s1a.a.g(r101).getAbility(s.class);
    L6:
        this.f551070j = r102;
        AbsInstructionWidget r103 = e(r100);
        r103.setComponentScope(this.f551064d);
        if (r101 == null) goto L9;
        r103.R5(r101);
    L9:
        r103.T5(this);
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    @Override // up8.d
    public a0 b(u r100, com.larus.bmhome.view.actionbar.edit.c r101, com.larus.bmhome.view.actionbar.edit.d r102, b r103) {
        this.f551062b = r100;
        this.f551063c = r101;
        this.f551066f = r103;
        a0 r104 = n(r100.f295477d);
        if (r102 == null) goto L7;
        Map<String, ?> r105 = r102.f316509a;
        if (r105 == null) goto L7;
        m(r105);
    L8:
        return r104;
    L7:
        o();
        goto L8
    }

    public a0 r(String r100, com.larus.bmhome.view.actionbar.edit.c r101, u r102, com.larus.bmhome.view.actionbar.edit.d r103, b r104) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        this.f551062b = r102;
        this.f551063c = r101;
        this.f551066f = r104;
        a0 r105 = n(r100);
        if (r103 == null) goto L7;
        Map<String, ?> r106 = r103.f316509a;
        if (r106 == null) goto L7;
        m(r106);
    L8:
        return r105;
    L7:
        o();
        goto L8
    }
}
