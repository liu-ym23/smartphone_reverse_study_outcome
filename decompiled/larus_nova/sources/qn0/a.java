package qn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sn0.l;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements l, sn0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sn0.a f533981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProducerResStep f533982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k.a f533983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f533984d;

    /* JADX INFO: renamed from: qn0.a$a, reason: collision with other inner class name */
    public interface InterfaceC7365a {
        void a(LayoutConfigModel r100);

        void onFailed(Throwable r100);
    }

    public interface b {
        void onFailed();

        void onSuccess();
    }

    public a(k.a r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f533983c = r100;
        this.f533984d = r101;
        this.f533982b = ProducerResStep.GeckoOffline;
    }

    @Override // sn0.a
    public final void c(pn0.d r100, pn0.g r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        boolean r102 = this.f533983c.f534008c.d().f529895c;
        boolean r103 = this.f533983c.f534008c.d().f529896d.contains(String.valueOf(r100.g()));
        if (r102 == false) goto L9;
        if (r103 == true) goto L9;
        HashMap<String, HashMap<String, String>> r104 = this.f533983c.f534006a;
        c r105 = new c(this, r100, r101);
        if (r104.isEmpty() == false) goto L8;
        qn0.b r106 = new qn0.b(this, r100, r101, r105);
        this.f533983c.f534008c.c().a(this.f533983c.f534008c.a() + "offset/entrance.json", new d(this, r100, r106));
        return;
    L8:
        f(r100, r101, r105);
        return;
    L9:
        d(r100.e(), "geckoOfflineProducer is banned by setting!!! ui_layout = " + r100.g() + ", geckoOfflineEnable = " + r102 + ", isDisableUILayout = " + r103 + ", disableUILayoutList = " + this.f533983c.f534008c.d().f529896d);
        sn0.a r107 = this.f533981a;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L12:
        r107.c(r100, r101);
    }

    public final void d(pn0.d.a r100, String r101) {
        StringBuilder r102 = r100.f529918a;
        r102.append("\n");
        r102.append("OffsetLayoutConfig step: " + this.f533982b + ", content: " + r101);
    }

    public final String e(List<Integer> r110, String r111) {
        if (r110 == null) goto L5;
        String r112 = CollectionsKt.joinToString$default(r110, "_", null, null, 0, null, null, 62, null);
        if (r112 == null) goto L5;
    L6:
        HashMap<String, String> r113 = this.f533983c.f534006a.get(r111);
        if (r113 != null) goto L11;
        return null;
    L11:
        return r113.get(r112);
    L5:
        r112 = "";
        goto L6
    }

    @Override // sn0.l
    public final void a(pn0.d r100, pn0.g r101, sn0.a r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r102, "consumer");
        this.f533981a = r102;
        l r103 = this.f533984d;
        if (r103 == null) goto L6;
        r103.a(r100, r101, this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.String] */
    public final void f(pn0.d r100, pn0.g r101, c r110) {
        int r102 = r100.g();
        int r103 = r101.f529939a;
        if (r103 == 0) goto L5;
        r102 = r103;
    L5:
        List<Integer> r104 = r100.f();
        d(r100.e(), "loadGeckoOffsetLayoutLayoutConfigByUIFeature uiFeatures(from server data): " + r104);
        Map<Integer, List<Integer>> r105 = r101.f529941c;
        boolean r106 = true;
        if (r105 != null) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == true) goto L19;
        ArrayList r108 = new ArrayList();
        List<Integer> r109 = r101.f529941c.get(Integer.valueOf(r102));
        if (r104 == null) goto L16;
        r108.addAll(r104);
    L16:
        if (r109 == null) goto L18;
        r108.addAll(r109);
    L18:
        d(r100.e(), "loadGeckoOffsetLayoutLayoutConfigByUIFeature offsetUIFeatureList(from client inject data): " + r109);
        r104 = CollectionsKt.sorted(r108);
    L19:
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        ?? r112 = e(r104, String.valueOf(r102));
        r111.element = r112;
        if (r112 != 0) goto L33;
        ArrayList r113 = new ArrayList();
        if (r104 == null) goto L31;
        Iterator r114 = r104.iterator();
    L25:
        if (r114.hasNext() == false) goto L31;
        String r115 = this.f533983c.f534007b.get(String.valueOf(((Number) r114.next()).intValue()));
        if (r115 == null) goto L25;
        int r116 = CastIntegerProtector.parseInt(r115);
        if (r113.contains(Integer.valueOf(r116)) == true) goto L25;
        r113.add(Integer.valueOf(r116));
    L31:
        CollectionsKt.sort(r113);
        r111.element = e(r113, String.valueOf(r102));
        r104 = r113;
    L33:
        if (((String) r111.element) != null) goto L35;
        r111.element = e(r104, "common");
    L35:
        String r117 = (String) r111.element;
        if (r117 != null) goto L38;
    L41:
        if (r106 == false) goto L44;
        r110.onFailed(new Throwable("targetFileName is null or empty, fileName: " + ((String) r111.element)));
        return;
    L44:
        this.f533983c.f534008c.c().a(this.f533983c.f534008c.a() + "offset/" + ((String) r111.element), new e(this, r100, r110, r111));
        return;
    L38:
        if (r117.length() == 0) goto L41;
        r106 = false;
        goto L41
    L8:
        if (r105.isEmpty() == true) goto L11;
        r107 = false;
        goto L12
    }

    @Override // sn0.a
    public final void b(pn0.d r100, pn0.g r101, LayoutConfigModel r102, ProducerResStep r103) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r102, "layoutConfigModel");
        Intrinsics.checkNotNullParameter(r103, "step");
        sn0.a r104 = this.f533981a;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r104.b(r100, r101, r102, r103);
    }
}
