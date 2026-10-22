package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.lark.pb.basic.v1.RichText;
import com.bytedance.lark.pb.im.v1.ASRTextResult;
import com.bytedance.lark.pb.im.v1.NERInfo;
import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewAudio2TextPush f409428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SendSpeechRecognitionResponse f409429b;

    public q(NewAudio2TextPush r100, SendSpeechRecognitionResponse r101) {
        this.f409428a = r100;
        this.f409429b = r101;
    }

    public final void a() {
        Iterator<n> r100 = this.f409428a.f409398c.iterator();
    L4:
        if (r100.hasNext() == false) goto L47;
        n r101 = r100.next();
        List<NERInfo> r102 = this.f409429b.ner_info;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        ArrayList r210 = null;
    L20:
        ASRTextResult r104 = this.f409429b.origin_asr_result;
        if (r104 == null) goto L23;
        List<NERInfo> r105 = r104.ner_info;
    L24:
        List<NERInfo> r106 = r105;
        if (r106 != null) goto L27;
    L30:
        boolean r107 = true;
    L31:
        if (r107 == false) goto L33;
    L32:
        ArrayList r211 = null;
    L42:
        SendSpeechRecognitionResponse r108 = this.f409429b;
        String r109 = r108.source_id;
        Integer r110 = r108.sequence_id;
        String r111 = r108.result;
        boolean r212 = r108.is_end.booleanValue();
        SendSpeechRecognitionResponse r112 = this.f409429b;
        List<Integer> r113 = r112.diff_index_slice;
        int r213 = r112.error_code.intValue();
        SendSpeechRecognitionResponse r114 = this.f409429b;
        RichText r115 = r114.rich_text_result;
        ASRTextResult r116 = r114.origin_asr_result;
        if (r116 == null) goto L45;
        RichText r214 = r116.rich_text_result;
    L46:
        r101.a(new a(r109, r110, r111, r212, r113, r213, r210, r115, r214, r211, r114.is_formatted.booleanValue()), true);
        goto L4
    L45:
        r214 = null;
        goto L46
    L33:
        ASRTextResult r117 = this.f409429b.origin_asr_result;
        if (r117 == null) goto L32;
        List<NERInfo> r118 = r117.ner_info;
        if (r118 == null) goto L32;
        List<NERInfo> r119 = r118;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator<T> r121 = r119.iterator();
    L39:
        if (r121.hasNext() == false) goto L41;
        NERInfo r122 = (NERInfo) r121.next();
        r120.add(new com.ss.android.lark.audio.voiceinput.a(r122.index_begin.intValue(), r122.index_end.intValue(), r122.text, r122.pinyin, r122.source_category, r122.source_index.intValue(), r122.lark_user_id, r122.lark_user_in_chat));
        goto L39
    L41:
        r211 = r120;
        goto L42
    L27:
        if (r106.isEmpty() == true) goto L30;
        r107 = false;
        goto L31
    L23:
        r105 = null;
        goto L24
    L15:
        List<NERInfo> r123 = this.f409429b.ner_info;
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
        Iterator<T> r125 = r123.iterator();
    L17:
        if (r125.hasNext() == false) goto L19;
        NERInfo r126 = (NERInfo) r125.next();
        r124.add(new com.ss.android.lark.audio.voiceinput.a(r126.index_begin.intValue(), r126.index_end.intValue(), r126.text, r126.pinyin, r126.source_category, r126.source_index.intValue(), r126.lark_user_id, r126.lark_user_in_chat));
        goto L17
    L19:
        r210 = r124;
        goto L20
    L8:
        if (r102.isEmpty() == true) goto L11;
        r103 = false;
        goto L13
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
