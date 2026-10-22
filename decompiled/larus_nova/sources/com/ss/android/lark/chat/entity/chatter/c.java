package com.ss.android.lark.chat.entity.chatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f415196a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f415197b = null;

    public static final class a implements com.ss.android.lark.chat.entity.chatter.b {
        public a() {
        }

        @Override // com.ss.android.lark.chat.entity.chatter.b
        public final List<TagInfo> a(List<TagInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "lst");
            ArrayList r101 = new ArrayList();
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L11;
            Object r103 = r102.next();
            if (((TagInfo) r103).getType() != TagType.ADMIN_USER) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == true) goto L4;
            r101.add(r103);
            goto L4
        L8:
            r104 = false;
            goto L9
        L11:
            return r101;
        }
    }

    public static final class b implements com.ss.android.lark.chat.entity.chatter.b {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.util.List<com.ss.android.lark.chat.entity.chatter.TagInfo>] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List<com.ss.android.lark.chat.entity.chatter.TagInfo>] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayList] */
        @Override // com.ss.android.lark.chat.entity.chatter.b
        public final List<TagInfo> a(List<TagInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "lst");
            Iterable r101 = (Iterable) r100;
            if ((r101 instanceof Collection) == true) goto L5;
        L7:
            Iterator r102 = r101.iterator();
        L9:
            if (r102.hasNext() == false) goto L16;
            if (((TagInfo) r102.next()).getType() != TagType.CLASS_TEACHER) goto L13;
            boolean r103 = true;
        L14:
            if (r103 == false) goto L9;
            boolean r104 = true;
        L17:
            if (r104 == false) goto L27;
            r100 = new ArrayList();
            Iterator r105 = r101.iterator();
        L20:
            if (r105.hasNext() == false) goto L27;
            Object r106 = r105.next();
            if (((TagInfo) r106).getType() != TagType.DISCIPLINE_TEACHER) goto L24;
            boolean r107 = true;
        L25:
            if (r107 == true) goto L20;
            r100.add(r106);
            goto L20
        L24:
            r107 = false;
        L27:
            return r100;
        L13:
            r103 = false;
        L16:
            r104 = false;
            goto L17
        L5:
            if (((Collection) r101).isEmpty() == false) goto L7;
            goto L7
        }
    }

    static {
        f415196a = new b();
        f415197b = new a();
    }
}
