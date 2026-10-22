package com.larus.im.internal.core.message.converter;

import ae9.e;
import android.os.SystemClock;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import nuc.v2;
import ouc.v;
import xt7.d;

/* JADX INFO: loaded from: classes29.dex */
public final class ConverterBaseKt {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r100).getLocalIndex()), Long.valueOf(((Message) r101).getLocalIndex()));
        }
    }

    public static final List<Message> b(Map<String, String> r100, List<Message> r101) {
        Intrinsics.checkNotNullParameter(r101, "dbList");
        if (r100 == null) goto L7;
        String r102 = r100.get("sub_messages_count");
        if (r102 == null) goto L7;
        Integer r103 = StringsKt.toIntOrNull(r102);
    L8:
        if (r103 != null) goto L10;
    L29:
        com.larus.im.internal.delegate.a.f348188b.e("ConverterBase", "calculateSubList, totalCount invalid");
        return r101;
    L10:
        if (r103.intValue() <= 0) goto L29;
        int r104 = r103.intValue();
        ArrayList r105 = new ArrayList(r104);
        int r106 = 0;
    L13:
        if (r106 >= r104) goto L28;
        Iterator<T> r107 = r101.iterator();
    L16:
        if (r107.hasNext() == false) goto L26;
        Object r108 = r107.next();
        Integer r109 = com.larus.im.bean.message.a.M((Message) r108);
        if (r109 != null) goto L21;
    L23:
        boolean r110 = false;
    L24:
        if (r110 == false) goto L16;
    L27:
        r105.add((Message) r108);
        r106 = r106 + 1;
        goto L13
    L21:
        if (r109.intValue() != r106) goto L23;
        r110 = true;
        goto L24
    L26:
        r108 = null;
        goto L27
    L28:
        return r105;
    L7:
        r103 = null;
        goto L8
    }

    public static final List<List<Message>> d(Map<String, String> r100, List<Message> r101) {
        Intrinsics.checkNotNullParameter(r101, "dbList");
        if (r100 == null) goto L7;
        String r102 = r100.get("sub_messages_count");
        if (r102 == null) goto L7;
        Integer r103 = StringsKt.toIntOrNull(r102);
    L8:
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<T> r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L15;
        Object r106 = r105.next();
        Integer r107 = com.larus.im.bean.message.a.M((Message) r106);
        Object r108 = r104.get(r107);
        if (r108 != null) goto L14;
        r108 = new ArrayList();
        r104.put(r107, r108);
    L14:
        ((List) r108).add(r106);
        goto L10
    L15:
        ArrayList r109 = new ArrayList(r104.size());
        Iterator r110 = r104.entrySet().iterator();
    L17:
        if (r110.hasNext() == false) goto L19;
        r109.add(CollectionsKt.sortedWith((Iterable) ((Map.Entry) r110.next()).getValue(), new a()));
        goto L17
    L19:
        if (r103 != null) goto L21;
    L45:
        com.larus.im.internal.delegate.a.f348188b.e("ConverterBase", "calculateSubListGroup, totalCount invalid");
        return r109;
    L21:
        if (r103.intValue() <= 0) goto L45;
        ArrayList r111 = new ArrayList();
        int r112 = r103.intValue();
        int r113 = 0;
    L24:
        if (r113 >= r112) goto L44;
        Iterator r114 = r109.iterator();
    L27:
        if (r114.hasNext() == false) goto L39;
        Object r115 = r114.next();
        Message r116 = (Message) CollectionsKt.firstOrNull((List) r115);
        if (r116 == null) goto L36;
        Integer r117 = com.larus.im.bean.message.a.M(r116);
        if (r117 == null) goto L36;
        if (r117.intValue() != r113) goto L36;
        boolean r118 = true;
    L37:
        if (r118 == false) goto L27;
    L40:
        List r119 = (List) r115;
        if (r119 != null) goto L43;
        r119 = CollectionsKt.emptyList();
    L43:
        r111.add(r119);
        r113 = r113 + 1;
    L36:
        r118 = false;
        goto L37
    L39:
        r115 = null;
        goto L40
    L44:
        return r111;
    L7:
        r103 = null;
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x011d -> B:40:0x0125). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01c3 -> B:64:0x01ca). Please report as a decompilation issue!!! */
    public static final Object a(MessageEntity r110, Map<String, String> r111, Continuation<? super List<Message>> r112) {
        MessageEntity r100 = r110;
        if ((r112 instanceof ConverterBaseKt$calculateSubList$1) == false) goto L7;
        ConverterBaseKt$calculateSubList$1 r101 = (ConverterBaseKt$calculateSubList$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 == 2) goto L18;
        if (r105 == 3) goto L17;
        if (r105 != 4) goto L16;
        long r106 = r101.J$0;
        Collection r107 = (Collection) r101.L$4;
        Iterator r108 = (Iterator) r101.L$3;
        Collection r109 = (Collection) r101.L$2;
        String r113 = (String) r101.L$1;
        Map<String, String> r114 = (Map) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r115 = r113;
        Iterator r116 = r108;
        long r117 = r106;
        Object r118 = r104;
        ConverterBaseKt$calculateSubList$1 r119 = r101;
        Object r120 = r103;
        Collection r121 = r109;
    L64:
        r107.add((Message) r120);
        r107 = r121;
        r101 = r119;
        r104 = r118;
        long r122 = r117;
        Iterator r123 = r116;
        String r124 = r115;
    L59:
        if (r123.hasNext() == false) goto L65;
        MessageEntity r125 = (MessageEntity) r123.next();
        r101.L$0 = r114;
        r101.L$1 = r124;
        r101.L$2 = r107;
        r101.L$3 = r123;
        r101.L$4 = r107;
        r101.J$0 = r122;
        r101.label = 4;
        Object r126 = MessageEntityConverterKt.a(r125, r101);
        if (r126 != r104) goto L63;
        return r104;
    L63:
        r115 = r124;
        r116 = r123;
        r117 = r122;
        r118 = r104;
        r119 = r101;
        r120 = r126;
        r121 = r107;
        goto L64
    L65:
        List r127 = (List) r107;
        long r128 = r122;
        String r129 = r124;
        Map<String, String> r130 = r114;
    L66:
        List<Message> r131 = b(r130, r127);
        long r132 = SystemClock.elapsedRealtime() - r128;
        com.larus.im.internal.delegate.a.f348188b.i("ConverterBase", "calculateSubList, parentMsgId:" + r129 + ",costTime:" + r132 + ",size:" + r131.size());
        return r131;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r122 = r101.J$0;
        String r133 = (String) r101.L$1;
        Map<String, String> r134 = (Map) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L57:
        Iterable r135 = (Iterable) r103;
        r124 = r133;
        r114 = r134;
        r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        r123 = r135.iterator();
        goto L59
    L18:
        r128 = r101.J$0;
        Collection r136 = (Collection) r101.L$5;
        Iterator r137 = (Iterator) r101.L$4;
        Collection r138 = (Collection) r101.L$3;
        String r139 = (String) r101.L$2;
        Map<String, String> r140 = (Map) r101.L$1;
        MessageEntity r141 = (MessageEntity) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L40:
        r136.add((Message) r103);
        r129 = r139;
        MessageEntity r142 = r141;
        r130 = r140;
        r136 = r138;
    L35:
        if (r137.hasNext() == false) goto L41;
        MessageEntity r143 = (MessageEntity) r137.next();
        r101.L$0 = r142;
        r101.L$1 = r130;
        r101.L$2 = r129;
        r101.L$3 = r136;
        r101.L$4 = r137;
        r101.L$5 = r136;
        r101.J$0 = r128;
        r101.label = 2;
        Object r144 = MessageEntityConverterKt.a(r143, r101);
        if (r144 != r104) goto L39;
        return r104;
    L39:
        r138 = r136;
        MessageEntity r145 = r142;
        r139 = r129;
        r103 = r144;
        r140 = r130;
        r141 = r145;
        goto L40
    L41:
        r127 = (List) r136;
        String r146 = r142.getSubList();
        if (r127.isEmpty() == false) goto L66;
        if (r146 != null) goto L45;
    L48:
        boolean r147 = true;
    L49:
        if (r147 == true) goto L66;
        com.larus.im.internal.delegate.a.f348188b.w("ConverterBase", "calculateSubList, subList is not empty");
        v r148 = d.f565073b;
        kuc.a.f(StringCompanionObject.INSTANCE);
        List<String> r149 = (List) r148.c(kuc.a.b(v2.f520790a), r146);
        if (r149 != null) goto L53;
        r149 = CollectionsKt.emptyList();
    L53:
        be9.d r150 = e.a();
        r101.L$0 = r130;
        r101.L$1 = r129;
        r101.L$2 = null;
        r101.L$3 = null;
        r101.L$4 = null;
        r101.L$5 = null;
        r101.J$0 = r128;
        r101.label = 3;
        Object r151 = ((MessageDaoSource) r150).h(r149, r101);
        if (r151 != r104) goto L56;
        return r104;
    L56:
        r134 = r130;
        r122 = r128;
        String r152 = r129;
        r103 = r151;
        r133 = r152;
        goto L57
    L45:
        if (r146.length() == 0) goto L48;
        r147 = false;
        goto L49
    L19:
        long r153 = r101.J$0;
        String r154 = (String) r101.L$2;
        r130 = (Map) r101.L$1;
        MessageEntity r155 = (MessageEntity) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r128 = r153;
        Object r156 = r103;
        r129 = r154;
        r100 = r155;
    L33:
        Iterable r157 = (Iterable) r156;
        ArrayList r158 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r157, 10));
        r137 = r157.iterator();
        r142 = r100;
        r136 = r158;
        goto L35
    L20:
        ResultKt.throwOnFailure(r103);
        Integer[] r159 = k.f348166a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (k.e(r110) != 66) goto L23;
        boolean r160 = true;
    L24:
        if (r160 == true) goto L26;
        return null;
    L26:
        long r161 = SystemClock.elapsedRealtime();
        r129 = r110.getMessageId();
        if (r129 != null) goto L29;
        r129 = "";
    L29:
        be9.d r162 = e.a();
        r101.L$0 = r100;
        r101.L$1 = r111;
        r101.L$2 = r129;
        r101.J$0 = r161;
        r101.label = 1;
        Object r163 = ((MessageDaoSource) r162).O(r129, r101);
        if (r163 != r104) goto L32;
        return r104;
    L32:
        r128 = r161;
        r156 = r163;
        r130 = r111;
        goto L33
    L23:
        r160 = false;
    L7:
        r101 = new ConverterBaseKt$calculateSubList$1(r112);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x011d -> B:40:0x0125). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01cd -> B:64:0x01d4). Please report as a decompilation issue!!! */
    public static final Object c(MessageEntity r110, Map<String, String> r111, Continuation<? super List<? extends List<Message>>> r112) {
        MessageEntity r100 = r110;
        if ((r112 instanceof ConverterBaseKt$calculateSubListGroup$1) == false) goto L7;
        ConverterBaseKt$calculateSubListGroup$1 r101 = (ConverterBaseKt$calculateSubListGroup$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 == 2) goto L18;
        if (r105 == 3) goto L17;
        if (r105 != 4) goto L16;
        long r106 = r101.J$0;
        Collection r107 = (Collection) r101.L$4;
        Iterator r108 = (Iterator) r101.L$3;
        Collection r109 = (Collection) r101.L$2;
        String r113 = (String) r101.L$1;
        Map<String, String> r114 = (Map) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r115 = r113;
        Iterator r116 = r108;
        long r117 = r106;
        Object r118 = r104;
        ConverterBaseKt$calculateSubListGroup$1 r119 = r101;
        Object r120 = r103;
        Collection r121 = r109;
    L64:
        r107.add((Message) r120);
        r107 = r121;
        r101 = r119;
        r104 = r118;
        long r122 = r117;
        Iterator r123 = r116;
        String r124 = r115;
    L59:
        if (r123.hasNext() == false) goto L65;
        MessageEntity r125 = (MessageEntity) r123.next();
        r101.L$0 = r114;
        r101.L$1 = r124;
        r101.L$2 = r107;
        r101.L$3 = r123;
        r101.L$4 = r107;
        r101.J$0 = r122;
        r101.label = 4;
        Object r126 = MessageEntityConverterKt.a(r125, r101);
        if (r126 != r104) goto L63;
        return r104;
    L63:
        r115 = r124;
        r116 = r123;
        r117 = r122;
        r118 = r104;
        r119 = r101;
        r120 = r126;
        r121 = r107;
        goto L64
    L65:
        List r127 = (List) r107;
        long r128 = r122;
        String r129 = r124;
        Map<String, String> r130 = r114;
    L66:
        List<List<Message>> r131 = d(r130, r127);
        long r132 = SystemClock.elapsedRealtime() - r128;
        com.larus.im.internal.delegate.a.f348188b.i("ConverterBase", "calculateSubListGroup, parentMsgId:" + r129 + ",costTime:" + r132 + ",size:" + ((ArrayList) r131).size());
        return r131;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r122 = r101.J$0;
        String r133 = (String) r101.L$1;
        Map<String, String> r134 = (Map) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L57:
        Iterable r135 = (Iterable) r103;
        r124 = r133;
        r114 = r134;
        r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        r123 = r135.iterator();
        goto L59
    L18:
        r128 = r101.J$0;
        Collection r136 = (Collection) r101.L$5;
        Iterator r137 = (Iterator) r101.L$4;
        Collection r138 = (Collection) r101.L$3;
        String r139 = (String) r101.L$2;
        Map<String, String> r140 = (Map) r101.L$1;
        MessageEntity r141 = (MessageEntity) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L40:
        r136.add((Message) r103);
        r129 = r139;
        MessageEntity r142 = r141;
        r130 = r140;
        r136 = r138;
    L35:
        if (r137.hasNext() == false) goto L41;
        MessageEntity r143 = (MessageEntity) r137.next();
        r101.L$0 = r142;
        r101.L$1 = r130;
        r101.L$2 = r129;
        r101.L$3 = r136;
        r101.L$4 = r137;
        r101.L$5 = r136;
        r101.J$0 = r128;
        r101.label = 2;
        Object r144 = MessageEntityConverterKt.a(r143, r101);
        if (r144 != r104) goto L39;
        return r104;
    L39:
        r138 = r136;
        MessageEntity r145 = r142;
        r139 = r129;
        r103 = r144;
        r140 = r130;
        r141 = r145;
        goto L40
    L41:
        r127 = (List) r136;
        String r146 = r142.getSubListGroup();
        if (r127.isEmpty() == false) goto L66;
        if (r146 != null) goto L45;
    L48:
        boolean r147 = true;
    L49:
        if (r147 == true) goto L66;
        com.larus.im.internal.delegate.a.f348188b.w("ConverterBase", "calculateSubListGroup, subListGroup is not empty");
        v r148 = d.f565073b;
        kuc.a.f(StringCompanionObject.INSTANCE);
        List r149 = (List) r148.c(kuc.a.b(kuc.a.b(v2.f520790a)), r146);
        if (r149 != null) goto L53;
        r149 = CollectionsKt.emptyList();
    L53:
        List<String> r150 = CollectionsKt.flatten(r149);
        be9.d r151 = e.a();
        r101.L$0 = r130;
        r101.L$1 = r129;
        r101.L$2 = null;
        r101.L$3 = null;
        r101.L$4 = null;
        r101.L$5 = null;
        r101.J$0 = r128;
        r101.label = 3;
        Object r152 = ((MessageDaoSource) r151).h(r150, r101);
        if (r152 != r104) goto L56;
        return r104;
    L56:
        r134 = r130;
        r122 = r128;
        String r153 = r129;
        r103 = r152;
        r133 = r153;
        goto L57
    L45:
        if (r146.length() == 0) goto L48;
        r147 = false;
        goto L49
    L19:
        long r154 = r101.J$0;
        String r155 = (String) r101.L$2;
        r130 = (Map) r101.L$1;
        MessageEntity r156 = (MessageEntity) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r128 = r154;
        Object r157 = r103;
        r129 = r155;
        r100 = r156;
    L33:
        Iterable r158 = (Iterable) r157;
        ArrayList r159 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r158, 10));
        r137 = r158.iterator();
        r142 = r100;
        r136 = r159;
        goto L35
    L20:
        ResultKt.throwOnFailure(r103);
        Integer[] r160 = k.f348166a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (k.e(r110) != 67) goto L23;
        boolean r161 = true;
    L24:
        if (r161 == true) goto L26;
        return null;
    L26:
        long r162 = SystemClock.elapsedRealtime();
        r129 = r110.getMessageId();
        if (r129 != null) goto L29;
        r129 = "";
    L29:
        be9.d r163 = e.a();
        r101.L$0 = r100;
        r101.L$1 = r111;
        r101.L$2 = r129;
        r101.J$0 = r162;
        r101.label = 1;
        Object r164 = ((MessageDaoSource) r163).O(r129, r101);
        if (r164 != r104) goto L32;
        return r104;
    L32:
        r128 = r162;
        r157 = r164;
        r130 = r111;
        goto L33
    L23:
        r161 = false;
    L7:
        r101 = new ConverterBaseKt$calculateSubListGroup$1(r112);
        goto L8
    }
}
