package com.obric.miniapp.alarm;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes33.dex */
public final class d extends EntityInsertionAdapter<a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `alarm` (`id`,`title`,`content`,`triggerTime`,`intervalMinutes`,`repeatCount`,`currentRepeatCount`,`isActive`,`createdAt`,`extraInfo`,`useSystemClock`,`token`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public d(AlarmDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, a r101) {
        a r102 = r101;
        String r103 = r102.f397416a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f397417b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f397418c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        int r106 = s.f397484a;
        Long r107 = s.a(r102.f397419d);
        if (r107 != null) goto L17;
        r100.bindNull(4);
    L18:
        r100.bindLong(5, r102.f397420e);
        r100.bindLong(6, r102.f397421f);
        r100.bindLong(7, r102.f397422g);
        r100.bindLong(8, r102.f397423h ? 1 : 0);
        Long r108 = s.a(r102.f397424i);
        if (r108 != null) goto L21;
        r100.bindNull(9);
    L22:
        String r109 = s.c(r102.f397425j);
        if (r109 != null) goto L25;
        r100.bindNull(10);
    L26:
        r100.bindLong(11, r102.f397426k ? 1 : 0);
        String r110 = r102.f397427l;
        if (r110 != null) goto L29;
        r100.bindNull(12);
        return;
    L29:
        r100.bindString(12, r110);
        return;
    L25:
        r100.bindString(10, r109);
        goto L26
    L21:
        r100.bindLong(9, r108.longValue());
        goto L22
    L17:
        r100.bindLong(4, r107.longValue());
        goto L18
    L13:
        r100.bindString(3, r105);
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
