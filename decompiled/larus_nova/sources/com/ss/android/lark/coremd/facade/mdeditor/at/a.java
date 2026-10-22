package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.larksuite.framework.utils.AndroidThrottle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f419765a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.mdeditor.at.a$a, reason: collision with other inner class name */
    public static final class C4944a {
    }

    public static final class b implements AndroidThrottle.d<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f419766a;

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final Collection<c> a() {
            List r100 = CollectionsKt.toMutableList(this.f419766a);
            ((ArrayList) this.f419766a).clear();
            return r100;
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final void clear() {
            ((ArrayList) this.f419766a).clear();
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final int size() {
            return ((ArrayList) this.f419766a).size();
        }

        public b() {
            this.f419766a = new ArrayList();
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final void put(c r100) {
            c r101 = r100;
            if (r101 == null) goto L6;
            ((ArrayList) this.f419766a).add(r101);
            return;
        }
    }

    public static final class c {
    }

    static {
    }
}
