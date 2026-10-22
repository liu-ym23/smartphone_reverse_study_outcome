package com.bytedance.ee.bear.edit.component.toolbar2.insertblock;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public final Map<CharSequence, InsertNewBlockData> a;

    public i() {
        LinkedHashMap r0 = new LinkedHashMap();
        this.a = r0;
        InsertNewBlockData r1 = InsertNewBlockData.h1;
        r0.put(r1.getKey(), r1);
        InsertNewBlockData r2 = InsertNewBlockData.h2;
        r0.put(r2.getKey(), r2);
        InsertNewBlockData r3 = InsertNewBlockData.h3;
        r0.put(r3.getKey(), r3);
        InsertNewBlockData r4 = InsertNewBlockData.h4;
        r0.put(r4.getKey(), r4);
        InsertNewBlockData r5 = InsertNewBlockData.h5;
        r0.put(r5.getKey(), r5);
        InsertNewBlockData r6 = InsertNewBlockData.h6;
        r0.put(r6.getKey(), r6);
        InsertNewBlockData r7 = InsertNewBlockData.h7;
        r0.put(r7.getKey(), r7);
        InsertNewBlockData r8 = InsertNewBlockData.h8;
        r0.put(r8.getKey(), r8);
        InsertNewBlockData r9 = InsertNewBlockData.h9;
        r0.put(r9.getKey(), r9);
        InsertNewBlockData r10 = InsertNewBlockData.orderedList;
        r0.put(r10.getKey(), r10);
        InsertNewBlockData r11 = InsertNewBlockData.unorderedList;
        r0.put(r11.getKey(), r11);
        InsertNewBlockData r12 = InsertNewBlockData.checkbox;
        r0.put(r12.getKey(), r12);
        InsertNewBlockData r13 = InsertNewBlockData.checkList;
        r0.put(r13.getKey(), r13);
        InsertNewBlockData r14 = InsertNewBlockData.codeList;
        r0.put(r14.getKey(), r14);
        InsertNewBlockData r16 = InsertNewBlockData.blockQuote;
        r0.put(r16.getKey(), r16);
        InsertNewBlockData r17 = InsertNewBlockData.hyperLink;
        r0.put(r17.getKey(), r17);
        InsertNewBlockData r18 = InsertNewBlockData.insertImage;
        r0.put(r18.getKey(), r18);
        InsertNewBlockData r19 = InsertNewBlockData.insertTable;
        r0.put(r19.getKey(), r19);
        InsertNewBlockData r20 = InsertNewBlockData.insertFile;
        r0.put(r20.getKey(), r20);
        InsertNewBlockData r21 = InsertNewBlockData.insertSeparator;
        r0.put(r21.getKey(), r21);
        InsertNewBlockData r22 = InsertNewBlockData.mentionUser;
        r0.put(r22.getKey(), r22);
        InsertNewBlockData r23 = InsertNewBlockData.mentionChat;
        r0.put(r23.getKey(), r23);
        InsertNewBlockData r24 = InsertNewBlockData.mentionFile;
        r0.put(r24.getKey(), r24);
        InsertNewBlockData r26 = InsertNewBlockData.equation;
        r0.put(r26.getKey(), r26);
        InsertNewBlockData r27 = InsertNewBlockData.calloutBlock;
        r0.put(r27.getKey(), r27);
        InsertNewBlockData r28 = InsertNewBlockData.insertCalendar;
        r0.put(r28.getKey(), r28);
        InsertNewBlockData r29 = InsertNewBlockData.insertReminder;
        r0.put(r29.getKey(), r29);
        InsertNewBlockData r30 = InsertNewBlockData.insertTask;
        r0.put(r30.getKey(), r30);
        InsertNewBlockData r31 = InsertNewBlockData.insertSheet;
        r0.put(r31.getKey(), r31);
        InsertNewBlockData r32 = InsertNewBlockData.insertBitable;
        r0.put(r32.getKey(), r32);
        InsertNewBlockData r33 = InsertNewBlockData.insertMindnote;
        r0.put(r33.getKey(), r33);
        InsertNewBlockData r34 = InsertNewBlockData.insertOkrBlock;
        r0.put(r34.getKey(), r34);
        InsertNewBlockData r36 = InsertNewBlockData.INSERT_AGENDA_BLOCK;
        r0.put(r36.getKey(), r36);
        InsertNewBlockData r37 = InsertNewBlockData.INSERT_TASK_LIST;
        r0.put(r37.getKey(), r37);
        InsertNewBlockData r38 = InsertNewBlockData.INSERT_FOLDER_BLOCK;
        r0.put(r38.getKey(), r38);
        InsertNewBlockData r39 = InsertNewBlockData.INSERT_SYNCED_SOURCE;
        r0.put(r39.getKey(), r39);
        InsertNewBlockData r40 = InsertNewBlockData.WHITE_BOARD;
        r0.put(r40.getKey(), r40);
    }

    public final InsertNewBlockData a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return null;
    L6:
        Map<CharSequence, InsertNewBlockData> r0 = this.a;
        Intrinsics.checkNotNull(r2);
        return (InsertNewBlockData) ((LinkedHashMap) r0).get(r2);
    }
}
