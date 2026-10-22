package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import androidx.core.app.NotificationCompat;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.InsertNewBlockData;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<CharSequence, CharSequence> f226358a;

    public w() {
        LinkedHashMap r100 = new LinkedHashMap();
        this.f226358a = r100;
        r100.put("addNewBlock", "addNewBlock");
        r100.put("separator", "separator");
        r100.put("blockTransform", "block Transform");
        r100.put("textTransform", "text Transform");
        r100.put(NotificationCompat.CATEGORY_REMINDER, NotificationCompat.CATEGORY_REMINDER);
        r100.put("alignTransform", "align Transform");
        r100.put("insertImage", "insert Image");
        r100.put("checkbox", "checkbox");
        r100.put("checkList", "checkList");
        r100.put("mention", "mention");
        r100.put("insertTable", "insert Table");
        r100.put("calloutBlock", "callout Block");
        r100.put("undo", "undo");
        r100.put("redo", "redo");
        r100.put("indentLeft", "indent Left");
        r100.put("indentRight", "indent Right");
        r100.put("transTask", "trans Task");
        r100.put(InsertNewBlockData.f226291h1.getKey(), "h1");
        r100.put(InsertNewBlockData.f226292h2.getKey(), "h2");
        r100.put(InsertNewBlockData.f226293h3.getKey(), "h3");
        r100.put(InsertNewBlockData.f226294h4.getKey(), "h4");
        r100.put(InsertNewBlockData.f226295h5.getKey(), "h5");
        r100.put(InsertNewBlockData.f226296h6.getKey(), "h6");
        r100.put(InsertNewBlockData.f226297h7.getKey(), "h7");
        r100.put(InsertNewBlockData.f226298h8.getKey(), "h8");
        r100.put(InsertNewBlockData.f226299h9.getKey(), "h9");
        r100.put(InsertNewBlockData.orderedList.getKey(), "orderedList");
        r100.put(InsertNewBlockData.unorderedList.getKey(), "unorderedList");
        r100.put(InsertNewBlockData.checkbox.getKey(), "checkbox");
        r100.put(InsertNewBlockData.checkList.getKey(), "checkList");
        r100.put(InsertNewBlockData.codeList.getKey(), "codeList");
        r100.put(InsertNewBlockData.blockQuote.getKey(), "blockQuote");
        r100.put(InsertNewBlockData.hyperLink.getKey(), "hyperLink");
        r100.put(InsertNewBlockData.insertImage.getKey(), "insert Image");
        r100.put(InsertNewBlockData.insertTable.getKey(), "insert Table");
        r100.put(InsertNewBlockData.insertFile.getKey(), "insert File");
        r100.put(InsertNewBlockData.insertSeparator.getKey(), "insert Separator");
        r100.put(InsertNewBlockData.mentionUser.getKey(), "mention User");
        r100.put(InsertNewBlockData.mentionChat.getKey(), "mention Chat");
        r100.put(InsertNewBlockData.mentionFile.getKey(), "mention File");
        r100.put(InsertNewBlockData.equation.getKey(), "equation");
        r100.put(InsertNewBlockData.calloutBlock.getKey(), "callout Block");
        r100.put(InsertNewBlockData.insertCalendar.getKey(), "insert Calendar");
        r100.put(InsertNewBlockData.insertReminder.getKey(), "insert Reminder");
        r100.put(InsertNewBlockData.insertTask.getKey(), "insert Task");
        r100.put(InsertNewBlockData.insertSheet.getKey(), "insert Sheet");
        r100.put(InsertNewBlockData.insertBitable.getKey(), "insert Bitable");
        r100.put(InsertNewBlockData.insertMindnote.getKey(), "insert Mindnote");
    }
}
