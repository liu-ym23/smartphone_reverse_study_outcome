package com.lynx.tasm.event;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class a extends LynxEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f383324a;

    public String c() {
        return "params";
    }

    public Map<String, Object> b() {
        return this.f383324a;
    }

    public a(int r100, String r101) {
        super(r100, r101, LynxEvent.LynxEventType.kCustom);
        this.f383324a = new HashMap();
    }

    public final void a(String r100, Object r101) {
        if (this.f383324a != null) goto L5;
        this.f383324a = new HashMap();
    L5:
        this.f383324a.put(r100, r101);
    }

    public a(int r100, String r101, Map<String, Object> r102) {
        super(r100, r101, LynxEvent.LynxEventType.kCustom);
        this.f383324a = r102;
    }
}
