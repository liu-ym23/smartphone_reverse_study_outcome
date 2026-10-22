package m87;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.pythia.predict.ComputingSubScorePredictManager;
import com.bytedance.pythia.predict.PowerSubScorePredictManager;
import com.bytedance.pythia.predict.PredictManager;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PredictManager f512470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PowerSubScorePredictManager f512471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ComputingSubScorePredictManager f512472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<a> f512473d;

    public final void a() {
        if (this.f512470a != null) goto L17;
        PredictManager r100 = new PredictManager();
        if (r100.f267110a == true) goto L15;
        r100.f267113d = r100.a().getFloat("instant_value", 0.0f);
        r100.f267114e.clear();
        String[] r101 = r100.a().getStringArray("recently_pool", null);
        if (r101 == null) goto L14;
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L14;
        String r104 = r101[r103];
        r100.f267114e.add(Float.valueOf(CastFloatProtector.parseFloat(r104)));     // Catch: NumberFormatException -> L45
    L13:
        r103 = r103 + 1;
    L14:
        r100.f267115f = r100.a().getFloat("recently_value", 0.0f);
        r100.f267116g = r100.a().getFloat("stable_value_v2", 0.0f);
        r100.a().getFloat("old_stable_value_v2", 0.0f);
        r100.a().getInt("stable_combined_count_v2", 0);
        r100.f267111b = new com.bytedance.pythia.predict.b(new com.bytedance.pythia.predict.a(r100.f267113d, r100.f267115f, r100.f267116g));
        r100.f267110a = true;
    L15:
        Unit r105 = Unit.INSTANCE;
        this.f512470a = r100;
    L17:
        if (this.f512471b != null) goto L31;
        PowerSubScorePredictManager r106 = new PowerSubScorePredictManager();
        if (r106.f267103a == true) goto L29;
        r106.f267105c = r106.a().getFloat("power_instant_value", 0.0f);
        r106.f267106d.clear();
        String[] r107 = r106.a().getStringArray("power_recently_pool", null);
        if (r107 == null) goto L28;
        int r108 = r107.length;
        int r109 = 0;
    L24:
        if (r109 >= r108) goto L28;
        String r110 = r107[r109];
        r106.f267106d.add(Float.valueOf(CastFloatProtector.parseFloat(r110)));     // Catch: NumberFormatException -> L46
    L27:
        r109 = r109 + 1;
    L28:
        r106.f267107e = r106.a().getFloat("power_recently_value", 0.0f);
        r106.f267108f = r106.a().getFloat("power_stable_value_v2", 0.0f);
        r106.a().getFloat("power_old_stable_value_v2", 0.0f);
        r106.a().getInt("power_stable_combined_count_v2", 0);
        new com.bytedance.pythia.predict.a(r106.f267105c, r106.f267107e, r106.f267108f);
        r106.f267103a = true;
    L29:
        Unit r111 = Unit.INSTANCE;
        this.f512471b = r106;
    L31:
        if (this.f512472c != null) goto L60;
        ComputingSubScorePredictManager r112 = new ComputingSubScorePredictManager();
        if (r112.f267096a == true) goto L43;
        r112.f267098c = r112.a().getFloat("computing_instant_value", 0.0f);
        r112.f267099d.clear();
        String[] r113 = r112.a().getStringArray("computing_recently_pool", null);
        if (r113 == null) goto L42;
        int r114 = r113.length;
        int r115 = 0;
    L38:
        if (r115 >= r114) goto L42;
        String r116 = r113[r115];
        r112.f267099d.add(Float.valueOf(CastFloatProtector.parseFloat(r116)));     // Catch: NumberFormatException -> L47
    L41:
        r115 = r115 + 1;
    L42:
        r112.f267100e = r112.a().getFloat("computing_recently_value", 0.0f);
        r112.f267101f = r112.a().getFloat("computing_stable_value_v2", 0.0f);
        r112.a().getFloat("computing_old_stable_value_v2", 0.0f);
        r112.a().getInt("computing_stable_combined_count_v2", 0);
        new com.bytedance.pythia.predict.a(r112.f267098c, r112.f267100e, r112.f267101f);
        r112.f267096a = true;
    L43:
        Unit r117 = Unit.INSTANCE;
        this.f512472c = r112;
        return;
    }

    public c() {
        this.f512473d = new CopyOnWriteArraySet();
        new CopyOnWriteArraySet();
        new CopyOnWriteArraySet();
    }
}
