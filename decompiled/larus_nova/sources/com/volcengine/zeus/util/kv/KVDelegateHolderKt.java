package com.volcengine.zeus.util.kv;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u0003H\u0087\b¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"kvStore", "Lkotlin/properties/ReadWriteProperty;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/volcengine/zeus/util/kv/IKVStore;", "key", "", "default", "(Lcom/volcengine/zeus/util/kv/IKVStore;Ljava/lang/String;Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "zeus-core_release"}, k = 2, mv = {1, 4, 2})
public final class KVDelegateHolderKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements ReadWriteProperty<Object, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IKVStore f462919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f462920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f462921c;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        public final T getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass r102 = Reflection.getOrCreateKotlinClass(Object.class);
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L10;
            IKVStore r103 = this.f462919a;
            String r104 = this.f462920b;
            Object r105 = this.f462921c;
            if (r105 == null) goto L8;
            T r106 = (T) Float.valueOf(r103.getFloat(r104, ((Float) r105).floatValue()));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return r106;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L10:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L17;
            IKVStore r107 = this.f462919a;
            String r108 = this.f462920b;
            Object r109 = this.f462921c;
            if (r109 == null) goto L15;
            T r110 = (T) Integer.valueOf(r107.getInt(r108, ((Integer) r109).intValue()));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return r110;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L17:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L24;
            T r111 = (T) this.f462919a.getString(this.f462920b, (String) this.f462921c);
            if (r111 != null) goto L22;
            r111 = (T) ((String) this.f462921c);
        L22:
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return r111;
        L24:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L31;
            IKVStore r112 = this.f462919a;
            String r113 = this.f462920b;
            Object r114 = this.f462921c;
            if (r114 == null) goto L29;
            T r115 = (T) Boolean.valueOf(r112.getBoolean(r113, ((Boolean) r114).booleanValue()));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return r115;
        L29:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L31:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L38;
            IKVStore r116 = this.f462919a;
            String r117 = this.f462920b;
            Object r118 = this.f462921c;
            if (r118 == null) goto L36;
            T r119 = (T) Long.valueOf(r116.getLong(r117, ((Long) r118).longValue()));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return r119;
        L36:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        L38:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L45;
            IKVStore r120 = this.f462919a;
            String r121 = this.f462920b;
            Object r122 = this.f462921c;
            if (r122 == null) goto L43;
            T r123 = (T) Double.valueOf(r120.getDouble(r121, ((Double) r122).doubleValue()));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return r123;
        L43:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
        L45:
            if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(byte[].class)) == false) goto L52;
            IKVStore r124 = this.f462919a;
            String r125 = this.f462920b;
            Object r126 = this.f462921c;
            if (r126 == null) goto L51;
            T r127 = (T) r124.getBytes(r125, (byte[]) r126);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return r127;
        L51:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
        L52:
            StringBuilder r128 = new StringBuilder("不支持的类型: ");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            r128.append(Object.class);
            throw new UnsupportedOperationException(r128.toString());
        }

        public a(IKVStore r100, String r101, Object r102) {
            this.f462919a = r100;
            this.f462920b = r101;
            this.f462921c = r102;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.properties.ReadWriteProperty
        public final void setValue(Object r100, KProperty<?> r101, T r102) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass r103 = Reflection.getOrCreateKotlinClass(Object.class);
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L10;
            IKVStore r104 = this.f462919a;
            String r105 = this.f462920b;
            if (r102 == 0) goto L8;
            r104.storeFloat(r105, ((Float) r102).floatValue());
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L10:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L17;
            IKVStore r106 = this.f462919a;
            String r107 = this.f462920b;
            if (r102 == 0) goto L15;
            r106.storeInt(r107, ((Integer) r102).intValue());
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L17:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L27;
            String r108 = (String) r102;
            if (r108 == null) goto L21;
            boolean r109 = true;
        L22:
            if (r109 == false) goto L25;
            this.f462919a.storeString(this.f462920b, r108);
            return;
        L25:
            throw new IllegalArgumentException(("不允许向 kvStore 写入 null，key=" + this.f462920b).toString());
        L21:
            r109 = false;
            goto L22
        L27:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L34;
            IKVStore r110 = this.f462919a;
            String r111 = this.f462920b;
            if (r102 == 0) goto L32;
            r110.storeBoolean(r111, ((Boolean) r102).booleanValue());
            return;
        L32:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L34:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
            IKVStore r112 = this.f462919a;
            String r113 = this.f462920b;
            if (r102 == 0) goto L39;
            r112.storeLong(r113, ((Long) r102).longValue());
            return;
        L39:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        L41:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L48;
            IKVStore r114 = this.f462919a;
            String r115 = this.f462920b;
            if (r102 == 0) goto L46;
            r114.storeDouble(r115, ((Double) r102).doubleValue());
            return;
        L46:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
        L48:
            if (Intrinsics.areEqual(r103, Reflection.getOrCreateKotlinClass(byte[].class)) == false) goto L55;
            IKVStore r116 = this.f462919a;
            String r117 = this.f462920b;
            if (r102 == 0) goto L54;
            r116.storeBytes(r117, (byte[]) r102);
            return;
        L54:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
        L55:
            StringBuilder r118 = new StringBuilder("不支持的类型: ");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            r118.append(Object.class);
            throw new UnsupportedOperationException(r118.toString());
        }
    }

    public static final /* synthetic */ <T> ReadWriteProperty<Object, T> kvStore(IKVStore r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$kvStore");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.needClassReification();
        return new a(r100, r101, r102);
    }
}
