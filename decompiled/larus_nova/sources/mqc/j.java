package mqc;

import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.facebook.keyframes.model.KFAnimation;
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

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f514952a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f514953b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f514954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f514955d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile SecretKey f514956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f514957f = null;

    public static final class a implements ReadWriteProperty<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IKVStore f514958a;

        public a(IKVStore r100) {
            this.f514958a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        public final String getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            KClass r102 = Reflection.getOrCreateKotlinClass(String.class);
            String r103 = "";
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L6;
            return (String) Float.valueOf(this.f514958a.getFloat("activity_hmac_key", ((Float) "").floatValue()));
        L6:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L9;
            return (String) Integer.valueOf(this.f514958a.getInt("activity_hmac_key", ((Integer) "").intValue()));
        L9:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L15;
            String r104 = this.f514958a.getString("activity_hmac_key", "");
            if (r104 == null) goto L35;
            r103 = r104;
        L35:
            return r103;
        L15:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L18;
            return (String) Boolean.valueOf(this.f514958a.getBoolean("activity_hmac_key", ((Boolean) "").booleanValue()));
        L18:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L21;
            return (String) Long.valueOf(this.f514958a.getLong("activity_hmac_key", ((Long) "").longValue()));
        L21:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L24;
            return (String) Double.valueOf(this.f514958a.getDouble("activity_hmac_key", ((Double) "").doubleValue()));
        L24:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(byte[].class)) == false) goto L32;
            byte[] r105 = this.f514958a.getBytes("activity_hmac_key", (byte[]) "");
            if (r105 == 0) goto L30;
            return (String) r105;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L32:
            throw new UnsupportedOperationException("不支持的类型: " + String.class);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.properties.ReadWriteProperty
        public final void setValue(Object r100, KProperty<?> r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            KClass r103 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L10;
            IKVStore r104 = this.f514958a;
            if (r102 == 0) goto L8;
            r104.storeFloat("activity_hmac_key", ((Float) r102).floatValue());
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L10:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L17;
            IKVStore r105 = this.f514958a;
            if (r102 == 0) goto L15;
            r105.storeInt("activity_hmac_key", ((Integer) r102).intValue());
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L17:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L27;
            String r106 = r102;
            if (r106 == null) goto L21;
            boolean r107 = true;
        L22:
            if (r107 == false) goto L25;
            this.f514958a.storeString("activity_hmac_key", r106);
            return;
        L25:
            throw new IllegalArgumentException("不允许向 kvStore 写入 null，key=activity_hmac_key".toString());
        L21:
            r107 = false;
            goto L22
        L27:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L34;
            IKVStore r108 = this.f514958a;
            if (r102 == 0) goto L32;
            r108.storeBoolean("activity_hmac_key", ((Boolean) r102).booleanValue());
            return;
        L32:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L34:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
            IKVStore r109 = this.f514958a;
            if (r102 == 0) goto L39;
            r109.storeLong("activity_hmac_key", ((Long) r102).longValue());
            return;
        L39:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        L41:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L48;
            IKVStore r110 = this.f514958a;
            if (r102 == 0) goto L46;
            r110.storeDouble("activity_hmac_key", ((Double) r102).doubleValue());
            return;
        L46:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
        L48:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(byte[].class)) == false) goto L56;
            IKVStore r111 = this.f514958a;
            if (r102 == 0) goto L54;
            r111.storeBytes("activity_hmac_key", (byte[]) r102);
            return;
        L54:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
        L56:
            throw new UnsupportedOperationException("不支持的类型: " + String.class);
        }
    }

    static {
        f514952a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "hmacString", "getHmacString()Ljava/lang/String;", 0))};
        f514957f = new j();
        f514953b = new a(KVStorage.INSTANCE.mainDynamicKV());
        f514955d = new Object();
    }

    public j() {
    }

    public final SecretKey b() {
        a r100 = f514953b;
        KProperty<?>[] r101 = f514952a;
        String r102 = (String) r100.getValue(this, r101[0]);
        if (r102.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L13;
        r102 = Base64.encodeToString(KeyGenerator.getInstance("HmacSHA256").generateKey().getEncoded(), 2);
        j r104 = f514957f;
        r104.getClass();
        r100.setValue(r104, r101[0], r102);
    L13:
        String r105 = f514954c;
        SecretKey r106 = f514956e;
        if (r105 != null) goto L16;
    L19:
        Object r107 = f514955d;
        monitor-enter(r107);
        String r108 = f514954c;     // Catch: Throwable -> L31
        SecretKey r109 = f514956e;     // Catch: Throwable -> L31
        if (r108 != null) goto L24;
    L28:
        SecretKeySpec r110 = new SecretKeySpec(Base64.decode(r102, 2), "HmacSHA256");     // Catch: Throwable -> L31
        f514956e = r110;     // Catch: Throwable -> L31
        f514954c = r102;     // Catch: Throwable -> L31
        monitor-exit(r107);
        return r110;
    L24:
        if (Intrinsics.areEqual(r108, r102) == false) goto L28;
        if (r109 == null) goto L28;
        monitor-exit(r107);
        return r109;
    L31:
        th = move-exception;
        throw th;
    L16:
        if (Intrinsics.areEqual(r105, r102) == false) goto L19;
        if (r106 == null) goto L19;
        return r106;
    L5:
        r103 = false;
        goto L6
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        Mac r101 = Mac.getInstance("HmacSHA256");
        r101.init(b());
        return Base64.encodeToString(r101.doFinal(r100.getBytes(Charsets.UTF_8)), 2);
    }
}
