package com.bytedance.dux.api;

import android.content.Context;
import android.text.Editable;
import android.widget.TextView;
import com.bytedance.dux.utils.ReplaceStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import nl4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&JB\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H&J\u001e\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\u0013\u001a\u00020\u0004H&J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/dux/api/IDuxEmojiService;", "", "Landroid/text/Editable$Factory;", "getEditableFactory", "", "enableParseEmojiSwitch", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "text", "", "lineHeight", "Lcom/bytedance/dux/utils/ReplaceStrategy;", "replaceStrategy", "maxParsingCount", "needRemoveOldSpan", "process", "Landroid/widget/TextView;", "textView", "systemEmojiLoaded", "Lnl4/a;", "callback", "", "addSystemEmojiLoadCallback", "removeSystemEmojiLoadCallback", "dux_release"}, k = 1, mv = {1, 7, 1})
public interface IDuxEmojiService {
    void addSystemEmojiLoadCallback(a r100);

    boolean enableParseEmojiSwitch();

    Editable.Factory getEditableFactory();

    CharSequence process(Context r100, CharSequence r101, int r102, ReplaceStrategy r103, int r104, boolean r105);

    CharSequence process(TextView r100, CharSequence r101);

    void removeSystemEmojiLoadCallback(a r100);

    boolean systemEmojiLoaded();
}
