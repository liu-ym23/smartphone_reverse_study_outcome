package dn9;

import androidx.core.app.NotificationCompat;
import com.larus.office.base.plugins.toolbar.InsertNewBlockData;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<CharSequence, CharSequence> f469387a;

    public k() {
        LinkedHashMap r100 = new LinkedHashMap();
        this.f469387a = r100;
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
        r100.put(InsertNewBlockData.f360811h1.getKey(), "h1");
        r100.put(InsertNewBlockData.f360812h2.getKey(), "h2");
        r100.put(InsertNewBlockData.f360813h3.getKey(), "h3");
        r100.put(InsertNewBlockData.orderedList.getKey(), "orderedList");
        r100.put(InsertNewBlockData.unorderedList.getKey(), "unorderedList");
        r100.put(InsertNewBlockData.checkbox.getKey(), "checkbox");
        r100.put(InsertNewBlockData.blockQuote.getKey(), "blockQuote");
    }
}
