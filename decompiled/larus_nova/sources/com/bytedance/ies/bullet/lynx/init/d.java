package com.bytedance.ies.bullet.lynx.init;

import com.lynx.devtoolwrapper.LynxDevtoolCardListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<c> f247343a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f247344b = null;

    public static final class a implements LynxDevtoolCardListener {
        public a() {
        }

        @Override // com.lynx.devtoolwrapper.LynxDevtoolCardListener
        public final void open(String r100) {
            ArrayList r101 = (ArrayList) d.f247343a;
            r101.size();
            Iterator r102 = r101.iterator();
        L4:
            if (r102.hasNext() == false) goto L12;
            c r103 = (c) r102.next();
            Objects.toString(r103);
            if (r103.a() == false) goto L4;
            r103.toString();
            return;
        }
    }

    static {
        f247343a = new ArrayList();
        f247344b = new a();
    }
}
