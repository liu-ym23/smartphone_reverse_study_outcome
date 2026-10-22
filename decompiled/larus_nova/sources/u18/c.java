package u18;

import androidx.camera.video.AudioStats;
import com.larksuite.framework.apiplugin.validator.format.Min;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Min f548318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f548319f;

    @Override // u18.a
    public final String b() {
        return this.f548319f + " is less than " + this.f548318e.value();
    }

    @Override // v18.a
    public final boolean check() {
        Object r100 = this.f548314c;
        if ((r100 instanceof Number) == false) goto L15;
        w18.a r101 = this.f548315d;
        double r102 = this.f548318e.value();
        double r103 = ((Number) this.f548314c).doubleValue();
        boolean r104 = this.f548318e.include();
        ((w18.b) r101).getClass();
        if (r104 == false) goto L8;
        if (r103 >= r102) goto L9;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == true) goto L42;
        this.f548319f = this.f548313b.getName();
        c(this.f548318e.warning());
        return false;
    L42:
        return true;
    L9:
        r105 = true;
        goto L11
    L8:
        if (r103 <= r102) goto L10;
    L15:
        if ((r100 instanceof List) == false) goto L27;
        w18.a r106 = this.f548315d;
        double r107 = this.f548318e.value();
        double r108 = ((List) this.f548314c).size();
        boolean r109 = this.f548318e.include();
        ((w18.b) r106).getClass();
        if (r109 == false) goto L20;
        if (r108 >= r107) goto L21;
    L22:
        boolean r110 = false;
    L23:
        if (r110 == true) goto L42;
        this.f548319f = this.f548313b.getName() + "'s length";
        c(this.f548318e.warning());
        return false;
    L21:
        r110 = true;
        goto L23
    L20:
        if (r108 <= r107) goto L22;
    L27:
        if ((r100 instanceof String) == false) goto L42;
        w18.a r111 = this.f548315d;
        double r112 = this.f548318e.value();
        Object r113 = this.f548314c;
        if (r113 != null) goto L31;
        double r114 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L32:
        boolean r115 = this.f548318e.include();
        ((w18.b) r111).getClass();
        if (r115 == false) goto L36;
        if (r114 >= r112) goto L37;
    L38:
        boolean r116 = false;
    L39:
        if (r116 == true) goto L42;
        this.f548319f = this.f548313b.getName() + "'s length";
        c(this.f548318e.warning());
        return false;
    L37:
        r116 = true;
        goto L39
    L36:
        if (r114 <= r112) goto L38;
    L31:
        r114 = ((String) r113).length();
        goto L32
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.f548318e.gray();
    }

    public c(Field r100, Min r101, Object r102, w18.a r103) {
        super(r100, r102, r103);
        this.f548318e = r101;
    }
}
