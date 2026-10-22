package mqc;

import android.util.Base64;
import com.volcengine.zeus.util.kv.IKVStore;
import com.volcengine.zeus.util.kv.KVStorage;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class j {
    public static final /* synthetic */ KProperty[] a = null;
    public static final a b = null;
    public static volatile String c;
    public static final Object d = null;
    public static volatile SecretKey e;
    public static final j f = null;

    public static final class a implements ReadWriteProperty<Object, String> {
        public final /* synthetic */ IKVStore a;

        public a(IKVStore r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        public final String getValue(Object r4, KProperty<?> r5) {
            Intrinsics.checkNotNullParameter(r4, "thisRef");
            Intrinsics.checkNotNullParameter(r5, "property");
            KClass r6 = Reflection.getOrCreateKotlinClass(String.class);
            boolean r7 = Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Float.TYPE));
            String r1 = XmlPullParser.NO_NAMESPACE;
            if (r7 == false) goto L6;
            return (String) Float.valueOf(this.a.getFloat("activity_hmac_key", ((Float) XmlPullParser.NO_NAMESPACE).floatValue()));
        L6:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L9;
            return (String) Integer.valueOf(this.a.getInt("activity_hmac_key", ((Integer) XmlPullParser.NO_NAMESPACE).intValue()));
        L9:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L15;
            String r8 = this.a.getString("activity_hmac_key", XmlPullParser.NO_NAMESPACE);
            if (r8 == null) goto L35;
            r1 = r8;
        L35:
            return r1;
        L15:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L18;
            return (String) Boolean.valueOf(this.a.getBoolean("activity_hmac_key", ((Boolean) XmlPullParser.NO_NAMESPACE).booleanValue()));
        L18:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L21;
            return (String) Long.valueOf(this.a.getLong("activity_hmac_key", ((Long) XmlPullParser.NO_NAMESPACE).longValue()));
        L21:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L24;
            return (String) Double.valueOf(this.a.getDouble("activity_hmac_key", ((Double) XmlPullParser.NO_NAMESPACE).doubleValue()));
        L24:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(byte[].class)) == false) goto L32;
            byte[] r9 = this.a.getBytes("activity_hmac_key", (byte[]) XmlPullParser.NO_NAMESPACE);
            if (r9 == 0) goto L30;
            return (String) r9;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L32:
            throw new UnsupportedOperationException("不支持的类型: " + String.class);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.properties.ReadWriteProperty
        public final void setValue(Object r2, KProperty<?> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "thisRef");
            Intrinsics.checkNotNullParameter(r3, "property");
            KClass r5 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L10;
            IKVStore r6 = this.a;
            if (r4 == 0) goto L8;
            r6.storeFloat("activity_hmac_key", ((Float) r4).floatValue());
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L10:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L17;
            IKVStore r7 = this.a;
            if (r4 == 0) goto L15;
            r7.storeInt("activity_hmac_key", ((Integer) r4).intValue());
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L17:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L27;
            String r8 = r4;
            if (r8 == null) goto L21;
            boolean r9 = true;
        L22:
            if (r9 == false) goto L25;
            this.a.storeString("activity_hmac_key", r8);
            return;
        L25:
            throw new IllegalArgumentException("不允许向 kvStore 写入 null，key=activity_hmac_key".toString());
        L21:
            r9 = false;
            goto L22
        L27:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L34;
            IKVStore r10 = this.a;
            if (r4 == 0) goto L32;
            r10.storeBoolean("activity_hmac_key", ((Boolean) r4).booleanValue());
            return;
        L32:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L34:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
            IKVStore r11 = this.a;
            if (r4 == 0) goto L39;
            r11.storeLong("activity_hmac_key", ((Long) r4).longValue());
            return;
        L39:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        L41:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L48;
            IKVStore r12 = this.a;
            if (r4 == 0) goto L46;
            r12.storeDouble("activity_hmac_key", ((Double) r4).doubleValue());
            return;
        L46:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
        L48:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(byte[].class)) == false) goto L56;
            IKVStore r13 = this.a;
            if (r4 == 0) goto L54;
            r13.storeBytes("activity_hmac_key", (byte[]) r4);
            return;
        L54:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
        L56:
            throw new UnsupportedOperationException("不支持的类型: " + String.class);
        }
    }

    static {
        a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "hmacString", "getHmacString()Ljava/lang/String;", 0))};
        f = new j();
        b = new a(KVStorage.INSTANCE.mainDynamicKV());
        d = new Object();
    }

    public j() {
    }

    public final SecretKey b() {
        a r0 = b;
        KProperty<?>[] r1 = a;
        String r3 = (String) r0.getValue(this, r1[0]);
        if (r3.length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L13;
        r3 = Base64.encodeToString(KeyGenerator.getInstance("HmacSHA256").generateKey().getEncoded(), 2);
        j r5 = f;
        r5.getClass();
        r0.setValue(r5, r1[0], r3);
    L13:
        String r2 = c;
        SecretKey r6 = e;
        if (r2 != null) goto L16;
    L19:
        Object r7 = d;
        monitor-enter(r7);
        String r8 = c;     // Catch: Throwable -> L31
        SecretKey r9 = e;     // Catch: Throwable -> L31
        if (r8 != null) goto L24;
    L28:
        SecretKeySpec r10 = new SecretKeySpec(Base64.decode(r3, 2), "HmacSHA256");     // Catch: Throwable -> L31
        e = r10;     // Catch: Throwable -> L31
        c = r3;     // Catch: Throwable -> L31
        monitor-exit(r7);
        return r10;
    L24:
        if (Intrinsics.areEqual(r8, r3) == false) goto L28;
        if (r9 == null) goto L28;
        monitor-exit(r7);
        return r9;
    L31:
        th = move-exception;
        throw th;
    L16:
        if (Intrinsics.areEqual(r2, r3) == false) goto L19;
        if (r6 == null) goto L19;
        return r6;
    L5:
        r4 = false;
        goto L6
    }

    public final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "payload");
        Mac r0 = Mac.getInstance("HmacSHA256");
        r0.init(b());
        return Base64.encodeToString(r0.doFinal(r3.getBytes(Charsets.UTF_8)), 2);
    }
}
