package tr7;

import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.value.SpecialChar;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Integer> f547310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Integer> f547311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f547312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f547313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f547314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<SpecialChar> f547315f;

    /* JADX INFO: renamed from: tr7.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C7765a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f547316a = null;

        static {
            int[] r100 = new int[CronFieldName.values().length];
            f547316a = r100;
            r100[CronFieldName.SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f547316a[CronFieldName.MINUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f547316a[CronFieldName.HOUR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f547316a[CronFieldName.DAY_OF_WEEK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f547316a[CronFieldName.DAY_OF_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f547316a[CronFieldName.MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f547316a[CronFieldName.DAY_OF_YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public final FieldConstraints a() {
        return new FieldConstraints(this.f547310a, this.f547311b, this.f547315f, this.f547312c, this.f547313d, this.f547314e);
    }

    public a() {
        this.f547310a = new HashMap();
        this.f547311b = new HashMap();
        this.f547312c = 0;
        this.f547313d = Integer.MAX_VALUE;
        this.f547314e = false;
        HashSet r100 = new HashSet();
        this.f547315f = r100;
        r100.add(SpecialChar.NONE);
    }

    public final void b(CronFieldName r110) {
        switch(C7765a.f547316a[r110.ordinal()]) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        this.f547312c = 1;
        this.f547313d = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME;
        return;
    L7:
        HashMap r111 = new HashMap();
        r111.put("JAN", 1);
        r111.put("FEB", 2);
        r111.put("MAR", 3);
        r111.put("APR", 4);
        r111.put("MAY", 5);
        r111.put("JUN", 6);
        r111.put("JUL", 7);
        r111.put("AUG", 8);
        r111.put("SEP", 9);
        r111.put("OCT", 10);
        r111.put("NOV", 11);
        r111.put("DEC", 12);
        this.f547310a = r111;
        this.f547312c = 1;
        this.f547313d = 12;
        return;
    L9:
        this.f547312c = 1;
        this.f547313d = 31;
        return;
    L11:
        HashMap r112 = new HashMap();
        r112.put("MON", 1);
        r112.put("TUE", 2);
        r112.put("WED", 3);
        r112.put("THU", 4);
        r112.put("FRI", 5);
        r112.put("SAT", 6);
        r112.put("SUN", 7);
        this.f547310a = r112;
        this.f547313d = 6;
        return;
    L13:
        this.f547313d = 23;
        return;
    L15:
        this.f547313d = 59;
    }
}
