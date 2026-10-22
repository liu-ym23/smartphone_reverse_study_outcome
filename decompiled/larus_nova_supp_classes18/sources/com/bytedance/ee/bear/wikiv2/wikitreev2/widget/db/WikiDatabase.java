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
import yq5.b0;
import yq5.f;
import yq5.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class WikiDatabase extends RoomDatabase {

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase$a$a, reason: collision with other inner class name */
        public class C0217a extends RoomDatabase.Callback {
            public C0217a() {
            }

            public final void onCreate(SupportSQLiteDatabase r2) {
                super.onCreate(r2);
                tt5.a.h("wiki.db", "onCreate");
            }

            public final void onOpen(SupportSQLiteDatabase r2) {
                super.onOpen(r2);
                tt5.a.h("wiki.db", "onOpen");
            }
        }

        public static final class b {
            public static final a a = null;

            static {
                a = new a();
            }
        }

        public a() {
            com.bytedance.ee.util.db.a r0 = DBController.a();
            DBController.a r1 = new DBController.a(eu5.b.a);
            r1.a = "wiki.db";
            r1.b = WikiDatabase.class;
            r1.d = new C0217a();
            r1.a(new Migration[]{new Migration1_2()});
            r1.a(new Migration[]{new Migration2_3()});
            r1.a(new Migration[]{new Migration3_4()});
            r1.a(new Migration[]{new Migration4_5()});
            r1.a(new Migration[]{new Migration5_6()});
            r1.a(new Migration[]{new Migration6_7()});
            r1.a(new Migration[]{new Migration7_8()});
            r1.a(new Migration[]{new Migration8_9()});
            r1.a(new Migration[]{new Migration9_10()});
            r1.a(new Migration[]{new Migration10_11()});
            r1.a(new Migration[]{new Migration11_12()});
            r1.a(new Migration[]{new MigrationTo13()});
            r1.a(new Migration[]{new MigrationTo14()});
            r1.a(new Migration[]{new MigrationTo15()});
            r1.a(new Migration[]{new MigrationTo16()});
            r1.a(new Migration[]{new MigrationTo17()});
            r0.W3("wiki.db", r1);
        }
    }

    public abstract f d();

    public abstract t e();

    public abstract b0 f();

    public static WikiDatabase c() {
        a.b.a.getClass();
        return (WikiDatabase) DBController.a().r1("wiki.db");
    }

    public WikiDatabase() {
    }
}
