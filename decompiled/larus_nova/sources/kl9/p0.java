package kl9;

import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.larus.multitask_management.api.data.TaskStatus;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class p0 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0 f503970c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<p0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f503971a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f503972b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{r100, kuc.a.d(r100), kuc.a.d(l0.a.f503936a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f503972b;
        }

        static {
            a r100 = new a();
            f503971a = r100;
            g2 r101 = new g2("com.larus.multitask_management.api.data.UpdateTaskRequest", r100, 3);
            r101.j("task_instance_id", false);
            r101.j("reference_id", true);
            r101.j("update_data", true);
            f503972b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f503972b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            String r102 = r111.decodeStringElement(r100, 0);
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            l0 r104 = (l0) r111.decodeNullableSerializableElement(r100, 2, l0.a.f503936a, null);
            int r105 = 7;
        L19:
            r111.endStructure(r100);
            return new p0(r105, r102, r103, r104);
        L5:
            String r106 = null;
            l0 r107 = null;
            int r108 = 0;
            boolean r109 = true;
        L6:
            if (r109 == false) goto L18;
            int r112 = r111.decodeElementIndex(r100);
            if (r112 != (-1)) goto L9;
            r109 = false;
            goto L6
        L9:
            if (r112 != 0) goto L10;
            r101 = r111.decodeStringElement(r100, 0);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r112 != 1) goto L11;
            r106 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r112 != 2) goto L14;
            r107 = (l0) r111.decodeNullableSerializableElement(r100, 2, l0.a.f503936a, r107);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r112);
        L18:
            r105 = r108;
            r102 = r101;
            r103 = r106;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            p0 r102 = (p0) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f503972b;
            muc.d r104 = r100.beginStructure(r103);
            boolean r105 = false;
            r104.encodeStringElement(r103, 0, r102.f503968a);
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f503969b);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L15;
        L16:
            r105 = true;
        L17:
            if (r105 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 2, l0.a.f503936a, r102.f503970c);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f503970c == null) goto L17;
        L6:
            if (r102.f503969b != null) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<p0> serializer() {
            return a.f503971a;
        }

        public static p0 a(u r110) {
            Intrinsics.checkNotNullParameter(r110, "taskBasicInfo");
            String r100 = r110.f503979a;
            String r101 = r110.f503981c;
            TaskStatus r102 = r110.f503985g;
            TaskDisplayStatus r103 = r110.f503986h;
            x r104 = r110.f503987i;
            List<p> r105 = r110.f503988j;
            p r106 = r110.f503989k;
            p r111 = r110.f503990l;
            c0 r112 = r110.f503991m;
            long r113 = r110.f503993o;
            v r114 = r110.f503994p;
            Map<String, String> r115 = r110.f503995q;
            Map<String, String> r107 = r110.f503996r;
            Map<String, String> r108 = r110.f503997s;
            return new p0(r100, r101, new l0(r102, r103, r104, r105, r106, r111, r112, Long.valueOf(r113), r114, r107, r108, r115));
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.f503968a, r101.f503968a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503969b, r101.f503969b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f503970c, r101.f503970c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f503968a.hashCode() * 31;
        String r101 = this.f503969b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        l0 r105 = this.f503970c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UpdateTaskRequest(taskId=" + this.f503968a + ", referenceId=" + this.f503969b + ", updateData=" + this.f503970c + ')';
    }

    static {
        Companion = new b();
    }

    public static p0 a(p0 r100, String r101) {
        String r102 = r100.f503969b;
        l0 r103 = r100.f503970c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        return new p0(r101, r102, r103);
    }

    public p0(String r100, String r101, l0 r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f503968a = r100;
        this.f503969b = r101;
        this.f503970c = r102;
    }

    public p0(int r100, String r101, String r102, l0 r103) {
        if (1 != (r100 & 1)) goto L13;
        this.f503968a = r101;
        if ((r100 & 2) != 0) goto L7;
        this.f503969b = null;
    L9:
        if ((r100 & 4) != 0) goto L11;
        this.f503970c = null;
        return;
    L11:
        this.f503970c = r103;
        return;
    L7:
        this.f503969b = r102;
        goto L9
    L13:
        b2.b(r100, 1, a.f503972b);
        throw null;
    }
}
