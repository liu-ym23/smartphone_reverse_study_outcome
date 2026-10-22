package bk5;

import com.bytedance.ee.docsdk.impl.base.DocumentType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class e {
    public final String a;

    public static final class a extends e {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("default");
        }
    }

    public static final class b extends e {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("document");
        }
    }

    public static final class c extends e {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super(DocumentType.VALUE_DRIVE);
        }
    }

    public final String getType() {
        return this.a;
    }

    public final String toString() {
        return this.a;
    }

    public e(String r1) {
        this.a = r1;
    }
}
