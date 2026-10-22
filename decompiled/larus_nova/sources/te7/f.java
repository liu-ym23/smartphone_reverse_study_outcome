package te7;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f545601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f545602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<JSONObject> f545603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f545604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f545605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Throwable> f545606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Integer f545607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f545608h;

    public f(Ref.ObjectRef<String> r100, a r101, Ref.ObjectRef<JSONObject> r102, LinkedHashMap<String, String> r103, Ref.ObjectRef<String> r104, Ref.ObjectRef<Throwable> r105, Integer r106, int r107) {
        this.f545601a = r100;
        this.f545602b = r101;
        this.f545603c = r102;
        this.f545604d = r103;
        this.f545605e = r104;
        this.f545606f = r105;
        this.f545607g = r106;
        this.f545608h = r107;
    }

    public final void a() {
        Ref.ObjectRef<String> r100 = this.f545601a;
        a r101 = this.f545602b;
        Ref.ObjectRef<JSONObject> r102 = this.f545603c;
        LinkedHashMap<String, String> r103 = this.f545604d;
        Ref.ObjectRef<String> r104 = this.f545605e;
        Ref.ObjectRef<Throwable> r105 = this.f545606f;
        Integer r106 = this.f545607g;
        int r107 = this.f545608h;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L15
        if (r100.element == null) goto L12;
        JSONObject r109 = r102.element;     // Catch: Throwable -> L15
        String r110 = r104.element;     // Catch: Throwable -> L15
        if (r110 != null) goto L8;
        r110 = "";
    L8:
        Throwable r111 = r105.element;     // Catch: Throwable -> L15
        if (r111 != null) goto L11;
        r111 = new Throwable(r100.element);     // Catch: Throwable -> L15
    L11:
        Unit r112 = r101.b(r109, r103, r110, r111, r106, r107);     // Catch: Throwable -> L15
    L13:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L15
    L17:
        a r114 = this.f545602b;
        LinkedHashMap<String, String> r115 = this.f545604d;
        Integer r116 = this.f545607g;
        int r117 = this.f545608h;
        Throwable r118 = Result.m9452exceptionOrNullimpl(r113);
        if (r118 == null) goto L24;
        r114.b(new JSONObject(), r115, "", r118, r116, r117);
        return;
    L24:
        return;
    L12:
        r101.a(r102.element, r103, r106, r107);     // Catch: Throwable -> L15
        r112 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
