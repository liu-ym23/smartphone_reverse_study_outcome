package com.larus.bmhome.nestedfile;

import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: com.larus.bmhome.nestedfile.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4098a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f313415a = null;

        static {
            int[] r100 = new int[FieldType.values().length];
            r100[FieldType.PARSE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FieldType.REVIEW_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f313415a = r100;
        }
    }

    public static final boolean a(EntityState r100) {
        if (r100 == null) goto L40;
        List<Integer> r101 = r100.getUpdateFields();
        if (r101 == null) goto L41;
        List<Integer> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L43;
        int r104 = ((Number) r103.next()).intValue();
        FieldType.a r105 = FieldType.Companion;
        Integer r106 = Integer.valueOf(r104);
        r105.getClass();
        FieldType r107 = FieldType.a.a(r106);
        int r108 = C4098a.f313415a[r107.ordinal()];
        if (r108 != 1) goto L17;
        FileParseState.a r109 = FileParseState.Companion;
        Integer r110 = r100.getParseState();
        r109.getClass();
        int r111 = FileParseState.FAILED.getValue();
        if (r110 != null) goto L29;
    L31:
        boolean r112 = false;
    L32:
        if (r112 == false) goto L13;
        return true;
    L29:
        if (r110.intValue() != r111) goto L31;
    L30:
        r112 = true;
        goto L32
    L17:
        if (r108 != 2) goto L31;
        FileReviewState.a r113 = FileReviewState.Companion;
        Integer r114 = r100.getReviewState();
        r113.getClass();
        int r115 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r114 == null) goto L31;
        if (r114.intValue() != r115) goto L31;
    L43:
        return false;
    L9:
        if (r102.isEmpty() == false) goto L11;
        return false;
    L41:
        return false;
    L40:
        return false;
    }
}
