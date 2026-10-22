package com.ss.android.lark.intent.export.api;

import android.content.Context;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.ss.android.lark.intent.export.entity.DispatchContext;
import com.ss.android.lark.intent.export.entity.input.IntentInput;
import com.ss.android.lark.intent.export.entity.output.IntentOutput;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J&\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/intent/export/api/IntentResolver;", "D", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "V", "Lcom/ss/android/lark/intent/export/entity/output/IntentOutput;", "", JSEventListener.ACTION_RESOLVE, PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intentInput", "dispatchContext", "Lcom/ss/android/lark/intent/export/entity/DispatchContext;", "(Landroid/content/Context;Lcom/ss/android/lark/intent/export/entity/input/IntentInput;Lcom/ss/android/lark/intent/export/entity/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IntentResolver<D extends IntentInput, V extends IntentOutput> {
    Object resolve(Context r100, D r101, DispatchContext r102, Continuation<? super V> r103);
}
