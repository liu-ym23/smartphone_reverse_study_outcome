package lda;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskStatus;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b0 extends com.obric.assistant.cocreationreview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleKey f508789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f508791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OmniTaskStatus f508794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OmniTaskTriggerType f508795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<c> f508796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f508797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f508798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a5 f508799l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f508788a, r101.f508788a) == true) goto L12;
        return false;
    L12:
        if (this.f508789b == r101.f508789b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508790c, r101.f508790c) == true) goto L18;
        return false;
    L18:
        if (this.f508791d == r101.f508791d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508792e, r101.f508792e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508793f, r101.f508793f) == true) goto L27;
        return false;
    L27:
        if (this.f508794g == r101.f508794g) goto L30;
        return false;
    L30:
        if (this.f508795h == r101.f508795h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f508796i, r101.f508796i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f508797j, r101.f508797j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f508798k, r101.f508798k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f508799l, r101.f508799l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f508788a.hashCode() * 31) + this.f508789b.hashCode()) * 31) + this.f508790c.hashCode()) * 31;
        long r101 = this.f508791d;
        int r102 = (((((((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f508792e.hashCode()) * 31) + this.f508793f.hashCode()) * 31) + this.f508794g.hashCode()) * 31) + this.f508795h.hashCode()) * 31) + this.f508796i.hashCode()) * 31) + this.f508797j.hashCode()) * 31) + this.f508798k.hashCode()) * 31;
        a5 r103 = this.f508799l;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "OmniUsageRecord(id=" + this.f508788a + ", module=" + this.f508789b + ", taskId=" + this.f508790c + ", createdAt=" + this.f508791d + ", userQuery=" + this.f508792e + ", doubaoAnswer=" + this.f508793f + ", status=" + this.f508794g + ", taskTriggerType=" + this.f508795h + ", steps=" + this.f508796i + ", timeCost=" + this.f508797j + ", payload=" + this.f508798k + ", feedback=" + this.f508799l + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.f508788a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.f508789b;
    }

    public /* synthetic */ b0(String r110, ModuleKey r111, String r112, long r113, String r210, String r211, OmniTaskStatus r212, OmniTaskTriggerType r213, List r214, String r215) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r112, null);
    }

    public b0(String r100, ModuleKey r101, String r102, long r103, String r104, String r105, OmniTaskStatus r106, OmniTaskTriggerType r110, List<c> r111, String r112, String r113, a5 r114) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r104, "userQuery");
        Intrinsics.checkNotNullParameter(r105, "doubaoAnswer");
        Intrinsics.checkNotNullParameter(r106, "status");
        Intrinsics.checkNotNullParameter(r110, "taskTriggerType");
        Intrinsics.checkNotNullParameter(r111, "steps");
        Intrinsics.checkNotNullParameter(r112, "timeCost");
        Intrinsics.checkNotNullParameter(r113, WsConstants.KEY_PAYLOAD);
        this.f508788a = r100;
        this.f508789b = r101;
        this.f508790c = r102;
        this.f508791d = r103;
        this.f508792e = r104;
        this.f508793f = r105;
        this.f508794g = r106;
        this.f508795h = r110;
        this.f508796i = r111;
        this.f508797j = r112;
        this.f508798k = r113;
        this.f508799l = r114;
    }
}
