package uba;

import android.view.View;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricAvailableManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import jc8.a;
import jc8.b;
import jc8.d;
import jc8.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class a<T extends jc8.a> extends b<T> {

    /* JADX INFO: renamed from: uba.a$a, reason: collision with other inner class name */
    public static final class C7858a {
    }

    static {
    }

    @Override // jc8.b
    public final String c() {
        return "ObricBaseBlockHolder";
    }

    @Override // jc8.b
    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L18
        View r101 = this.f498155c;     // Catch: Throwable -> L18
        if (r101 == null) goto L15;
        IObricAvailableManager r102 = (IObricAvailableManager) ServiceManager.get().getService(IObricAvailableManager.class);     // Catch: Throwable -> L18
        if (r102 == null) goto L10;
        boolean r103 = true;
        if (r102.a() != true) goto L10;
    L11:
        FLogger.f375446a.d("ObricBaseBlockHolder", "checkIsDefaultAssistant isDefaultAssistant=" + r103);     // Catch: Throwable -> L18
        if (r103 == true) goto L14;
        r101.setAlpha(0.3f);     // Catch: Throwable -> L18
        j(r101);     // Catch: Throwable -> L18
    L14:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
        return;
    L10:
        r103 = false;
        goto L11
    L15:
        r104 = null;
    L18:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public a() {
    }

    public static void j(View r100) {
        r100.setOnClickListener(null);
        r100.setOnLongClickListener(null);
        int r101 = 0;
        r100.setClickable(false);
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
    L5:
        if (r101 >= r103) goto L9;
        j(r102.getChildAt(r101));
        r101 = r101 + 1;
        goto L5
    L9:
        return;
    }

    @Override // jc8.b
    public final d f(T r100) {
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        return e.d(r100);
    }
}
