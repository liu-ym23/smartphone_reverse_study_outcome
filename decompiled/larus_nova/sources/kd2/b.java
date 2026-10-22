package kd2;

import com.bytedance.android.live.core.log.ALogger;
import vm2.h;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f502716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f502717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f502718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f502719d;

    public static final class a {
    }

    static {
    }

    public b() {
        this(0, 0);
    }

    public final boolean b() {
        int r100 = this.f502718c;
        if (r100 == 1) goto L5;
    L7:
        return false;
    L5:
        if (r100 != this.f502719d) goto L7;
        return true;
    }

    public final boolean a(int r100) {
        if (r100 != 1) goto L20;
        if (r100 != this.f502718c) goto L10;
        if (r100 != this.f502719d) goto L10;
        return false;
    L10:
        if (r100 == this.f502719d) goto L14;
        ALogger.i("SpeechRecognitionAedState", "start change, currentState: " + this.f502719d + ", newState: " + r100);
        this.f502719d = r100;
        if (this.f502718c == r100) goto L14;
        return false;
    L14:
        int r101 = this.f502718c;
        int r102 = this.f502719d;
        if (r101 == r102) goto L31;
        if (r102 != r100) goto L32;
        ALogger.i("SpeechRecognitionAedState", "update state, targetState: " + this.f502718c + ", newState: " + r100);
        this.f502718c = r100;
    L18:
        return true;
    L32:
        return false;
    L31:
        return false;
    L20:
        if (r100 != this.f502718c) goto L25;
        if (r100 != this.f502719d) goto L25;
        return false;
    L25:
        if (r100 != this.f502719d) goto L27;
        this.f502716a++;
    L28:
        this.f502719d = r100;
        if (this.f502716a != this.f502717b) goto L34;
        ALogger.i("SpeechRecognitionAedState", this.f502717b + " times change, new state: " + r100 + ", currentState: " + this.f502719d);
        this.f502718c = this.f502719d;
        goto L18
    L34:
        return false;
    L27:
        this.f502716a = 1;
        goto L28
    }

    public b(int r100, int r101) {
        this.f502718c = r100;
        this.f502719d = r101;
        this.f502717b = h.t().a();
    }
}
