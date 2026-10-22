package com.lynx.tasm.fontface;

import android.util.Pair;
import com.obric.miniapp.alarm.AccountType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class FontFace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<TYPE, String>> f383377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f383378b;

    public static final enum TYPE extends Enum<TYPE> {
        public static final TYPE LOCAL = null;
        public static final TYPE URL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TYPE[] f383379a = null;

        static {
            TYPE r100 = new TYPE("URL", 0);
            URL = r100;
            TYPE r101 = new TYPE(AccountType.LOCAL, 1);
            LOCAL = r101;
            f383379a = new TYPE[]{r100, r101};
        }

        public static TYPE[] values() {
            return (TYPE[]) f383379a.clone();
        }

        public static TYPE valueOf(String r100) {
            return (TYPE) r27.a.a(TYPE.class, r100);
        }

        public TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public FontFace() {
        this.f383377a = new ArrayList();
    }
}
