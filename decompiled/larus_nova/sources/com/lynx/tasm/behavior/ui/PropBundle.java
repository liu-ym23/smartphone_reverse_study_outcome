package com.lynx.tasm.behavior.ui;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes32.dex */
public class PropBundle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JavaOnlyMap f382364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JavaOnlyArray f382365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JavaOnlyArray f382366c;

    public static PropBundle createPropBundle() {
        return new PropBundle();
    }

    public void resetEventHandler() {
        JavaOnlyArray r100 = this.f382365b;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.clear();
    }

    public PropBundle shallowCopy() {
        PropBundle r100 = new PropBundle();
        r100.f382364a = JavaOnlyMap.shallowCopy(getProps());
        if (getEventHandlers() == null) goto L6;
        r100.f382365b = JavaOnlyArray.shallowCopy(getEventHandlers());
    L6:
        if (getGestures() == null) goto L8;
        r100.f382366c = JavaOnlyArray.shallowCopy(getGestures());
    L8:
        return r100;
    }

    public PropBundle() {
        this.f382364a = new JavaOnlyMap();
        this.f382365b = null;
        this.f382366c = null;
    }

    public ReadableArray getEventHandlers() {
        return this.f382365b;
    }

    public ReadableArray getGestures() {
        return this.f382366c;
    }

    public ReadableMap getProps() {
        return this.f382364a;
    }

    public boolean contains(String r100) {
        return this.f382364a.containsKey(r100);
    }

    public void putEventHandler(JavaOnlyMap r100) {
        if (this.f382365b != null) goto L5;
        this.f382365b = new JavaOnlyArray();
    L5:
        this.f382365b.pushMap(r100);
    }

    public void putGesture(JavaOnlyMap r100) {
        if (this.f382366c != null) goto L5;
        this.f382366c = new JavaOnlyArray();
    L5:
        this.f382366c.pushMap(r100);
    }

    public void putNull(String r100) {
        this.f382364a.putNull(r100);
    }

    public void putArray(String r100, JavaOnlyArray r101) {
        this.f382364a.putArray(r100, r101);
    }

    public void putBool(String r100, boolean r101) {
        this.f382364a.putBoolean(r100, r101);
    }

    public void putDouble(String r100, double r101) {
        this.f382364a.putDouble(r100, r101);
    }

    public void putInt(String r100, int r101) {
        this.f382364a.putInt(r100, r101);
    }

    public void putLong(String r100, long r101) {
        this.f382364a.putLong(r100, r101);
    }

    public void putMap(String r100, JavaOnlyMap r101) {
        this.f382364a.putMap(r100, r101);
    }

    public void putString(String r100, String r101) {
        this.f382364a.putString(r100, r101);
    }
}
