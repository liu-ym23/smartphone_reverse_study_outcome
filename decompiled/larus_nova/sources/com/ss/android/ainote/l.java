package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteScene;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f406837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f406838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f406839c;

    public static final class a {
    }

    static {
    }

    public final void d() {
        int r100 = t.f407207a;
        t.a("AINoteEventBuilder", "send, eventType=" + this.f406837a + ", payload=" + this.f406839c);
        r0 r101 = this.f406838b;
        if (r101 == null) goto L6;
        r101.onEvent(this.f406837a, this.f406839c);
        return;
    }

    public final l a(xra.a r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        Long r101 = Long.valueOf(r100.c());
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.toString();
    L8:
        b("note_id", r103);
        AINoteCreateSource r104 = n.b(r100);
        if (r104 == null) goto L11;
        String r105 = r104.toEventValue();
    L12:
        b("note_source", r105);
        if (r100.f564908m != AINoteContentState.USE) goto L15;
        boolean r106 = true;
    L16:
        Boolean r107 = Boolean.valueOf(r106);
        if (r107 == null) goto L19;
        r102 = r107.toString();
    L19:
        b("is_ai_polish", r102);
        return this;
    L15:
        r106 = false;
        goto L16
    L11:
        r105 = null;
        goto L12
    L7:
        r103 = null;
        goto L8
    }

    public final void c(AINoteScene r100) {
        if (r100 != null) goto L4;
        String r101 = null;
    L8:
        b("scene", r101);
        return;
    L4:
        if (r100 != AINoteScene.Meeting) goto L6;
        r101 = "conference";
        goto L8
    L6:
        r101 = "record";
        goto L8
    }

    public l(String r100, r0 r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        this.f406837a = r100;
        this.f406838b = r101;
        this.f406839c = new JSONObject();
    }

    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 != null) goto L5;
        return;
    L5:
        this.f406839c.put(r100, r101);
    }
}
