package com.bytedance.ee.util.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    String Aa(Context r100, String r101);

    void M0(boolean r100);

    void W3(String r100, DBController.a r101);

    void e2(Context r100);

    String getKey();

    void init(String r100);

    <T extends RoomDatabase> T r1(String r100);

    @Deprecated(message = "After user container, no need to listen key change")
    void x7(DBController.b r100);
}
