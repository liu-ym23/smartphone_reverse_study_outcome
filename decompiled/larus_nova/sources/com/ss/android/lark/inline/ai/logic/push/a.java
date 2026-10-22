package com.ss.android.lark.inline.ai.logic.push;

import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements slb.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final slb.d.a f427330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AbstractC5057a> f427331b;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.push.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC5057a implements slb.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f427332a;

        public AbstractC5057a() {
        }

        public final void b(InlineAITaskStatus r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            a r102 = this.f427332a;
            if (r102 == null) goto L12;
            int r103 = ((ArrayList) r102.f427331b).indexOf(this);
            if (r103 >= 0) goto L7;
        L10:
            r102.f427330a.a(r100, r101);
            return;
        L7:
            if (r103 >= (((ArrayList) r102.f427331b).size() - 1)) goto L10;
            ((AbstractC5057a) ListProtector.get(r102.f427331b, r103 + 1)).a(r100, r101);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public a(slb.d.a r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        this.f427330a = r100;
        this.f427331b = new ArrayList();
    }

    public final void b(AbstractC5057a r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        if (((ArrayList) this.f427331b).contains(r100) == true) goto L6;
        Intrinsics.checkNotNullParameter(this, "handler");
        r100.f427332a = this;
        ((ArrayList) this.f427331b).add(r100);
        return;
    }

    @Override // slb.d.a
    public final void a(InlineAITaskStatus r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        StringBuilder r102 = new StringBuilder("onPush()... taskId = ");
        r102.append(r100.unique_task_id);
        r102.append(", status = ");
        r102.append(r100.task_status);
        r102.append(", code = ");
        r102.append(r100.status_code);
        r102.append(", content length = ");
        String r103 = r100.content;
        if (r103 == null) goto L5;
        Integer r104 = Integer.valueOf(r103.length());
    L6:
        r102.append(r104);
        r102.append(", seq id = ");
        r102.append(r100.seq_id);
        Log.i("InlineAIPushHandler", r102.toString());
        if (((ArrayList) this.f427331b).isEmpty() == false) goto L10;
        this.f427330a.a(r100, r101);
        return;
    L10:
        ((AbstractC5057a) ListProtector.get(this.f427331b, 0)).a(r100, r101);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
