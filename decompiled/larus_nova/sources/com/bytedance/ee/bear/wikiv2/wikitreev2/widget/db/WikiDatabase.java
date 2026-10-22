package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db;

import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration10_11;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration11_12;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration1_2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration2_3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration3_4;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration4_5;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration5_6;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration6_7;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration7_8;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration8_9;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.Migration9_10;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.MigrationTo13;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.MigrationTo14;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.MigrationTo15;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.MigrationTo16;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration.MigrationTo17;
import com.bytedance.ee.util.db.DBController;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import yq5.b0;
import yq5.f;
import yq5.t;

/* JADX INFO: loaded from: classes18.dex */
public abstract class WikiDatabase extends RoomDatabase {

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase$a$a, reason: collision with other inner class name */
        public class C3464a extends RoomDatabase.Callback {
            public C3464a() {
            }

            @Override // androidx.room.RoomDatabase.Callback
            public final void onCreate(SupportSQLiteDatabase r100) {
                super.onCreate(r100);
                tt5.a.h("wiki.db", WidgetCostModule.TYPE_ON_CREATE);
            }

            @Override // androidx.room.RoomDatabase.Callback
            public final void onOpen(SupportSQLiteDatabase r100) {
                super.onOpen(r100);
                tt5.a.h("wiki.db", "onOpen");
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f241742a = null;

            static {
                f241742a = new a();
            }
        }

        public a() {
            com.bytedance.ee.util.db.a r100 = DBController.a();
            DBController.a r101 = new DBController.a(eu5.b.f474075a);
            r101.f243099a = "wiki.db";
            r101.f243100b = WikiDatabase.class;
            r101.f243102d = new C3464a();
            r101.a(new Migration[]{new Migration1_2()});
            r101.a(new Migration[]{new Migration2_3()});
            r101.a(new Migration[]{new Migration3_4()});
            r101.a(new Migration[]{new Migration4_5()});
            r101.a(new Migration[]{new Migration5_6()});
            r101.a(new Migration[]{new Migration6_7()});
            r101.a(new Migration[]{new Migration7_8()});
            r101.a(new Migration[]{new Migration8_9()});
            r101.a(new Migration[]{new Migration9_10()});
            r101.a(new Migration[]{new Migration10_11()});
            r101.a(new Migration[]{new Migration11_12()});
            r101.a(new Migration[]{new MigrationTo13()});
            r101.a(new Migration[]{new MigrationTo14()});
            r101.a(new Migration[]{new MigrationTo15()});
            r101.a(new Migration[]{new MigrationTo16()});
            r101.a(new Migration[]{new MigrationTo17()});
            r100.W3("wiki.db", r101);
        }
    }

    public abstract f d();

    public abstract t e();

    public abstract b0 f();

    public static WikiDatabase c() {
        a.b.f241742a.getClass();
        return (WikiDatabase) DBController.a().r1("wiki.db");
    }

    public WikiDatabase() {
    }
}
