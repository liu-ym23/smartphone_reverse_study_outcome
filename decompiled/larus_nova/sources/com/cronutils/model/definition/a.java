package com.cronutils.model.definition;

import com.cronutils.model.CronType;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.FieldDefinition;
import com.cronutils.model.field.value.SpecialChar;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import ur7.e;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<CronFieldName, FieldDefinition> f273553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<CronConstraint> f273554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<CronNicknames> f273555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f273556d;

    /* JADX INFO: renamed from: com.cronutils.model.definition.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class C3822a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f273557a = null;

        static {
            int[] r100 = new int[CronType.values().length];
            f273557a = r100;
            r100[CronType.CRON4J.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f273557a[CronType.QUARTZ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f273557a[CronType.UNIX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f273557a[CronType.SPRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f273557a[CronType.SPRING53.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final CronDefinition a() {
        HashSet r100 = new HashSet();
        r100.addAll(this.f273554b);
        ArrayList r101 = new ArrayList(((EnumMap) this.f273553a).values());
        r101.sort(FieldDefinition.createFieldDefinitionComparator());
        return new CronDefinition(r101, r100, this.f273555c, this.f273556d);
    }

    public a() {
        this.f273553a = new EnumMap(CronFieldName.class);
        this.f273554b = new HashSet();
        this.f273555c = new HashSet();
    }

    public static CronDefinition b(CronType r110) {
        int r100 = C3822a.f273557a[r110.ordinal()];
        if (r100 != 1) goto L5;
        a r111 = new a();
        CronFieldName r101 = CronFieldName.MINUTE;
        zr7.a.b(r101, "CronFieldName must not be null");
        tr7.a r102 = new tr7.a();
        r102.b(r101);
        r102.f547312c = 0;
        r102.f547313d = 59;
        r102.f547314e = true;
        r111.c(new FieldDefinition(r101, r102.a(), false));
        CronFieldName r103 = CronFieldName.HOUR;
        zr7.a.b(r103, "CronFieldName must not be null");
        tr7.a r104 = new tr7.a();
        r104.b(r103);
        r104.f547312c = 0;
        r104.f547313d = 23;
        r104.f547314e = true;
        r111.c(new FieldDefinition(r103, r104.a(), false));
        e r105 = new e(r111, CronFieldName.DAY_OF_MONTH);
        r105.e(0, 31);
        r105.d();
        r105.f551385c.f547314e = true;
        a r112 = r105.a();
        r112.getClass();
        CronFieldName r106 = CronFieldName.MONTH;
        zr7.a.b(r106, "CronFieldName must not be null");
        tr7.a r107 = new tr7.a();
        r107.b(r106);
        r107.f547312c = 1;
        r107.f547313d = 12;
        r107.f547314e = true;
        r112.c(new FieldDefinition(r106, r107.a(), false));
        ur7.a r108 = new ur7.a(r112, CronFieldName.DAY_OF_WEEK);
        r108.h(0, 6);
        r108.g(1);
        r108.f551385c.f547314e = true;
        a r113 = r108.a();
        r113.f273556d = true;
        return r113.a();
    L5:
        if (r100 != 2) goto L7;
        a r114 = new a();
        CronFieldName r109 = CronFieldName.SECOND;
        zr7.a.b(r109, "CronFieldName must not be null");
        tr7.a r115 = new tr7.a();
        r115.b(r109);
        r115.f547312c = 0;
        r115.f547313d = 59;
        r114.c(new FieldDefinition(r109, r115.a(), false));
        CronFieldName r116 = CronFieldName.MINUTE;
        zr7.a.b(r116, "CronFieldName must not be null");
        tr7.a r117 = new tr7.a();
        r117.b(r116);
        r117.f547312c = 0;
        r117.f547313d = 59;
        r114.c(new FieldDefinition(r116, r117.a(), false));
        CronFieldName r118 = CronFieldName.HOUR;
        zr7.a.b(r118, "CronFieldName must not be null");
        tr7.a r119 = new tr7.a();
        r119.b(r118);
        r119.f547312c = 0;
        r119.f547313d = 23;
        r114.c(new FieldDefinition(r118, r119.a(), false));
        e r120 = new e(r114, CronFieldName.DAY_OF_MONTH);
        r120.e(1, 31);
        r120.d();
        ((HashSet) r120.f551385c.f547315f).add(SpecialChar.W);
        ((HashSet) r120.f551385c.f547315f).add(SpecialChar.LW);
        r120.c();
        a r121 = r120.a();
        r121.getClass();
        CronFieldName r122 = CronFieldName.MONTH;
        zr7.a.b(r122, "CronFieldName must not be null");
        tr7.a r123 = new tr7.a();
        r123.b(r122);
        r123.f547312c = 1;
        r123.f547313d = 12;
        r121.c(new FieldDefinition(r122, r123.a(), false));
        ur7.a r124 = new ur7.a(r121, CronFieldName.DAY_OF_WEEK);
        r124.h(1, 7);
        r124.g(2);
        ((HashSet) r124.f551385c.f547315f).add(SpecialChar.HASH);
        r124.d();
        r124.c();
        a r125 = r124.a();
        r125.getClass();
        CronFieldName r126 = CronFieldName.YEAR;
        zr7.a.b(r126, "CronFieldName must not be null");
        tr7.a r127 = new tr7.a();
        r127.b(r126);
        r127.f547312c = 1970;
        r127.f547313d = 2099;
        r127.f547314e = true;
        r125.c(new FieldDefinition(r126, r127.a(), true));
        final String r128 = "Both, a day-of-week AND a day-of-month parameter, are not supported.";
        ((HashSet) r125.f273554b).add(new CronConstraintsFactory$2(r128));
        return r125.a();
    L7:
        if (r100 != 3) goto L9;
        a r129 = new a();
        CronFieldName r130 = CronFieldName.MINUTE;
        zr7.a.b(r130, "CronFieldName must not be null");
        tr7.a r131 = new tr7.a();
        r131.b(r130);
        r131.f547312c = 0;
        r131.f547313d = 59;
        r131.f547314e = true;
        r129.c(new FieldDefinition(r130, r131.a(), false));
        CronFieldName r132 = CronFieldName.HOUR;
        zr7.a.b(r132, "CronFieldName must not be null");
        tr7.a r133 = new tr7.a();
        r133.b(r132);
        r133.f547312c = 0;
        r133.f547313d = 23;
        r133.f547314e = true;
        r129.c(new FieldDefinition(r132, r133.a(), false));
        e r134 = new e(r129, CronFieldName.DAY_OF_MONTH);
        r134.e(1, 31);
        r134.f551385c.f547314e = true;
        a r135 = r134.a();
        r135.getClass();
        CronFieldName r136 = CronFieldName.MONTH;
        zr7.a.b(r136, "CronFieldName must not be null");
        tr7.a r137 = new tr7.a();
        r137.b(r136);
        r137.f547312c = 1;
        r137.f547313d = 12;
        r137.f547314e = true;
        r135.c(new FieldDefinition(r136, r137.a(), false));
        ur7.a r138 = new ur7.a(r135, CronFieldName.DAY_OF_WEEK);
        r138.h(0, 7);
        r138.g(1);
        r138.f();
        r138.f551385c.f547314e = true;
        return r138.a().a();
    L9:
        if (r100 != 4) goto L11;
        a r139 = new a();
        CronFieldName r140 = CronFieldName.SECOND;
        zr7.a.b(r140, "CronFieldName must not be null");
        tr7.a r141 = new tr7.a();
        r141.b(r140);
        r141.f547312c = 0;
        r141.f547313d = 59;
        r141.f547314e = true;
        r139.c(new FieldDefinition(r140, r141.a(), false));
        CronFieldName r142 = CronFieldName.MINUTE;
        zr7.a.b(r142, "CronFieldName must not be null");
        tr7.a r143 = new tr7.a();
        r143.b(r142);
        r143.f547312c = 0;
        r143.f547313d = 59;
        r143.f547314e = true;
        r139.c(new FieldDefinition(r142, r143.a(), false));
        CronFieldName r144 = CronFieldName.HOUR;
        zr7.a.b(r144, "CronFieldName must not be null");
        tr7.a r145 = new tr7.a();
        r145.b(r144);
        r145.f547312c = 0;
        r145.f547313d = 23;
        r145.f547314e = true;
        r139.c(new FieldDefinition(r144, r145.a(), false));
        e r146 = new e(r139, CronFieldName.DAY_OF_MONTH);
        r146.e(1, 31);
        r146.c();
        a r147 = r146.a();
        r147.getClass();
        CronFieldName r148 = CronFieldName.MONTH;
        zr7.a.b(r148, "CronFieldName must not be null");
        tr7.a r149 = new tr7.a();
        r149.b(r148);
        r149.f547312c = 1;
        r149.f547313d = 12;
        r147.c(new FieldDefinition(r148, r149.a(), false));
        ur7.a r150 = new ur7.a(r147, CronFieldName.DAY_OF_WEEK);
        r150.h(0, 7);
        r150.g(1);
        r150.f();
        ((HashSet) r150.f551385c.f547315f).add(SpecialChar.HASH);
        r150.c();
        return r150.a().a();
    L11:
        if (r100 != 5) goto L15;
        a r151 = new a();
        CronFieldName r152 = CronFieldName.SECOND;
        zr7.a.b(r152, "CronFieldName must not be null");
        tr7.a r153 = new tr7.a();
        r153.b(r152);
        r153.f547312c = 0;
        r153.f547313d = 59;
        r153.f547314e = true;
        r151.c(new FieldDefinition(r152, r153.a(), false));
        CronFieldName r154 = CronFieldName.MINUTE;
        zr7.a.b(r154, "CronFieldName must not be null");
        tr7.a r155 = new tr7.a();
        r155.b(r154);
        r155.f547312c = 0;
        r155.f547313d = 59;
        r155.f547314e = true;
        r151.c(new FieldDefinition(r154, r155.a(), false));
        CronFieldName r156 = CronFieldName.HOUR;
        zr7.a.b(r156, "CronFieldName must not be null");
        tr7.a r157 = new tr7.a();
        r157.b(r156);
        r157.f547312c = 0;
        r157.f547313d = 23;
        r157.f547314e = true;
        r151.c(new FieldDefinition(r156, r157.a(), false));
        e r158 = new e(r151, CronFieldName.DAY_OF_MONTH);
        r158.e(1, 31);
        r158.d();
        ((HashSet) r158.f551385c.f547315f).add(SpecialChar.W);
        ((HashSet) r158.f551385c.f547315f).add(SpecialChar.LW);
        r158.c();
        a r159 = r158.a();
        r159.getClass();
        CronFieldName r160 = CronFieldName.MONTH;
        zr7.a.b(r160, "CronFieldName must not be null");
        tr7.a r161 = new tr7.a();
        r161.b(r160);
        r161.f547312c = 1;
        r161.f547313d = 12;
        r159.c(new FieldDefinition(r160, r161.a(), false));
        ur7.a r162 = new ur7.a(r159, CronFieldName.DAY_OF_WEEK);
        r162.h(0, 7);
        r162.g(1);
        r162.f();
        ((HashSet) r162.f551385c.f547315f).add(SpecialChar.HASH);
        r162.d();
        r162.c();
        a r163 = r162.a();
        ((HashSet) r163.f273555c).add(CronNicknames.YEARLY);
        ((HashSet) r163.f273555c).add(CronNicknames.ANNUALLY);
        ((HashSet) r163.f273555c).add(CronNicknames.MONTHLY);
        ((HashSet) r163.f273555c).add(CronNicknames.WEEKLY);
        ((HashSet) r163.f273555c).add(CronNicknames.DAILY);
        ((HashSet) r163.f273555c).add(CronNicknames.MIDNIGHT);
        ((HashSet) r163.f273555c).add(CronNicknames.HOURLY);
        return r163.a();
    L15:
        throw new IllegalArgumentException(String.format("No cron definition found for %s", new Object[]{r110}));
    }

    public final void c(FieldDefinition r100) {
        Iterator r101 = ((EnumMap) this.f273553a).values().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (((FieldDefinition) r101.next()).isOptional() == false) goto L4;
        boolean r102 = true;
    L10:
        if (r100.isOptional() == true) goto L15;
        if (r102 == false) goto L15;
        throw new IllegalArgumentException("Can't register mandatory definition after a optional definition.");
    L15:
        Map<CronFieldName, FieldDefinition> r103 = this.f273553a;
        EnumMap r104 = (EnumMap) r103;
        r104.put(r100.getFieldName(), r100);
        return;
    L8:
        r102 = false;
        goto L10
    }
}
