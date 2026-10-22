package com.larus.abtest.api;

import androidx.exifinterface.media.ExifInterface;
import k38.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&J1\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00122\u0006\u0010\u0013\u001a\u0002H\u0010H&¢\u0006\u0002\u0010\u0014J9\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u0016JA\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u0018JI\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/larus/abtest/api/IAbTest;", "", "isInit", "", "refresh", "", "getUserVids", "", "uid", "updateUserId", "userId", "getLibraExperimentCache", "Lorg/json/JSONObject;", "getExposureInfo", "key", "getExperimentValue", ExifInterface.GPS_DIRECTION_TRUE, "tClass", "Ljava/lang/Class;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "withExposure", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Z)Ljava/lang/Object;", "isSticky", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;ZZ)Ljava/lang/Object;", "isBindToUser", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;ZZZ)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAbTest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286085a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J1\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u0002H\u0017H\u0016¢\u0006\u0002\u0010\u001bJ9\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u0002H\u00172\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001dJA\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u0002H\u00172\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001fJI\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u0002H\u00172\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0002\u0010!R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\""}, d2 = {"Lcom/larus/abtest/api/IAbTest$Companion;", "Lcom/larus/abtest/api/IAbTest;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/abtest/api/IAbTest;", "impl$delegate", "Lkotlin/Lazy;", "isInit", "", "refresh", "", "getUserVids", "", "uid", "updateUserId", "userId", "getLibraExperimentCache", "Lorg/json/JSONObject;", "getExposureInfo", "key", "getExperimentValue", ExifInterface.GPS_DIRECTION_TRUE, "tClass", "Ljava/lang/Class;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "withExposure", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Z)Ljava/lang/Object;", "isSticky", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;ZZ)Ljava/lang/Object;", "isBindToUser", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;ZZZ)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAbTest {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286086b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IAbTest> f286087c = null;

        private Companion() {
        }

        static {
            f286086b = new Companion();
            f286087c = LazyKt.lazy(new a());
        }

        @Override // com.larus.abtest.api.IAbTest
        public final void refresh() {
            IAbTest r100 = f286087c.getValue();
            if (r100 == null) goto L6;
            r100.refresh();
            return;
        }

        @Override // com.larus.abtest.api.IAbTest
        public final JSONObject s() {
            IAbTest r100 = f286087c.getValue();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.s();
        }

        @Override // com.larus.abtest.api.IAbTest
        public final void t(String r100) {
            IAbTest r101 = f286087c.getValue();
            if (r101 == null) goto L6;
            r101.t(r100);
            return;
        }

        @Override // com.larus.abtest.api.IAbTest
        public final <T> T r(String r100, Class<T> r101, T r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "tClass");
            IAbTest r103 = f286087c.getValue();
            if (r103 == null) goto L9;
            T r104 = (T) r103.r(r100, r101, r102);
            if (r104 != null) goto L8;
            return r102;
        L8:
            return r104;
        L9:
            return r102;
        }

        @Override // com.larus.abtest.api.IAbTest
        public final <T> T getExperimentValue(String r100, Class<T> r101, T r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "tClass");
            IAbTest r104 = f286087c.getValue();
            if (r104 == null) goto L9;
            T r105 = (T) r104.getExperimentValue(r100, r101, r102, r103);
            if (r105 != null) goto L8;
            return r102;
        L8:
            return r105;
        L9:
            return r102;
        }
    }

    static {
        f286085a = Companion.f286086b;
    }

    <T> T getExperimentValue(String r100, Class<T> r101, T r102, boolean r103);

    <T> T r(String r100, Class<T> r101, T r102);

    void refresh();

    JSONObject s();

    void t(String r100);
}
