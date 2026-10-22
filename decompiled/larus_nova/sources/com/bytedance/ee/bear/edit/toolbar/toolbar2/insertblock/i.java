package com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<CharSequence, InsertNewBlockData> f226343a;

    public i() {
        LinkedHashMap r100 = new LinkedHashMap();
        this.f226343a = r100;
        InsertNewBlockData r101 = InsertNewBlockData.f226291h1;
        r100.put(r101.getKey(), r101);
        InsertNewBlockData r102 = InsertNewBlockData.f226292h2;
        r100.put(r102.getKey(), r102);
        InsertNewBlockData r103 = InsertNewBlockData.f226293h3;
        r100.put(r103.getKey(), r103);
        InsertNewBlockData r104 = InsertNewBlockData.f226294h4;
        r100.put(r104.getKey(), r104);
        InsertNewBlockData r105 = InsertNewBlockData.f226295h5;
        r100.put(r105.getKey(), r105);
        InsertNewBlockData r106 = InsertNewBlockData.f226296h6;
        r100.put(r106.getKey(), r106);
        InsertNewBlockData r107 = InsertNewBlockData.f226297h7;
        r100.put(r107.getKey(), r107);
        InsertNewBlockData r108 = InsertNewBlockData.f226298h8;
        r100.put(r108.getKey(), r108);
        InsertNewBlockData r109 = InsertNewBlockData.f226299h9;
        r100.put(r109.getKey(), r109);
        InsertNewBlockData r110 = InsertNewBlockData.orderedList;
        r100.put(r110.getKey(), r110);
        InsertNewBlockData r111 = InsertNewBlockData.unorderedList;
        r100.put(r111.getKey(), r111);
        InsertNewBlockData r112 = InsertNewBlockData.checkbox;
        r100.put(r112.getKey(), r112);
        InsertNewBlockData r113 = InsertNewBlockData.checkList;
        r100.put(r113.getKey(), r113);
        InsertNewBlockData r114 = InsertNewBlockData.codeList;
        r100.put(r114.getKey(), r114);
        InsertNewBlockData r115 = InsertNewBlockData.blockQuote;
        r100.put(r115.getKey(), r115);
        InsertNewBlockData r116 = InsertNewBlockData.hyperLink;
        r100.put(r116.getKey(), r116);
        InsertNewBlockData r117 = InsertNewBlockData.insertImage;
        r100.put(r117.getKey(), r117);
        InsertNewBlockData r118 = InsertNewBlockData.insertTable;
        r100.put(r118.getKey(), r118);
        InsertNewBlockData r119 = InsertNewBlockData.insertFile;
        r100.put(r119.getKey(), r119);
        InsertNewBlockData r120 = InsertNewBlockData.insertSeparator;
        r100.put(r120.getKey(), r120);
        InsertNewBlockData r121 = InsertNewBlockData.mentionUser;
        r100.put(r121.getKey(), r121);
        InsertNewBlockData r122 = InsertNewBlockData.mentionChat;
        r100.put(r122.getKey(), r122);
        InsertNewBlockData r123 = InsertNewBlockData.mentionFile;
        r100.put(r123.getKey(), r123);
        InsertNewBlockData r124 = InsertNewBlockData.equation;
        r100.put(r124.getKey(), r124);
        InsertNewBlockData r125 = InsertNewBlockData.calloutBlock;
        r100.put(r125.getKey(), r125);
        InsertNewBlockData r126 = InsertNewBlockData.insertCalendar;
        r100.put(r126.getKey(), r126);
        InsertNewBlockData r127 = InsertNewBlockData.insertReminder;
        r100.put(r127.getKey(), r127);
        InsertNewBlockData r128 = InsertNewBlockData.insertTask;
        r100.put(r128.getKey(), r128);
        InsertNewBlockData r129 = InsertNewBlockData.insertSheet;
        r100.put(r129.getKey(), r129);
        InsertNewBlockData r130 = InsertNewBlockData.insertBitable;
        r100.put(r130.getKey(), r130);
        InsertNewBlockData r131 = InsertNewBlockData.insertMindnote;
        r100.put(r131.getKey(), r131);
        InsertNewBlockData r132 = InsertNewBlockData.insertOkrBlock;
        r100.put(r132.getKey(), r132);
        InsertNewBlockData r133 = InsertNewBlockData.INSERT_AGENDA_BLOCK;
        r100.put(r133.getKey(), r133);
        InsertNewBlockData r134 = InsertNewBlockData.INSERT_TASK_LIST;
        r100.put(r134.getKey(), r134);
        InsertNewBlockData r135 = InsertNewBlockData.INSERT_FOLDER_BLOCK;
        r100.put(r135.getKey(), r135);
        InsertNewBlockData r136 = InsertNewBlockData.INSERT_SYNCED_SOURCE;
        r100.put(r136.getKey(), r136);
        InsertNewBlockData r137 = InsertNewBlockData.WHITE_BOARD;
        r100.put(r137.getKey(), r137);
    }

    public final InsertNewBlockData a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        Map<CharSequence, InsertNewBlockData> r101 = this.f226343a;
        Intrinsics.checkNotNull(r100);
        return (InsertNewBlockData) ((LinkedHashMap) r101).get(r100);
    }
}
