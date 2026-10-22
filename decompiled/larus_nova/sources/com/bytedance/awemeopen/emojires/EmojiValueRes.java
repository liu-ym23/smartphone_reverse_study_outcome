package com.bytedance.awemeopen.emojires;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import m44.b;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/awemeopen/emojires/EmojiValueRes;", "", "", "Lm44/b;", "getRecEmojiList", "getEmojiList", "", "string", "Landroid/content/res/Resources;", "resources", "Landroid/graphics/drawable/Drawable;", "getEmoji", "", "", "DEFAULT_NAME_NAD_ID", "Ljava/util/Map;", "<init>", "()V", "ao_emoji_res_release"}, k = 1, mv = {1, 7, 1})
public final class EmojiValueRes {
    private static final Map<String, Integer> DEFAULT_NAME_NAD_ID = null;
    public static final EmojiValueRes INSTANCE = null;

    private EmojiValueRes() {
    }

    static {
        INSTANCE = new EmojiValueRes();
        DEFAULT_NAME_NAD_ID = MapsKt.mapOf(new Pair[]{TuplesKt.to("[心]", Integer.valueOf(R.drawable.aos_im_e107)), TuplesKt.to("[玫瑰]", Integer.valueOf(R.drawable.aos_im_e58)), TuplesKt.to("[捂脸]", Integer.valueOf(R.drawable.aos_im_e19)), TuplesKt.to("[比心]", Integer.valueOf(R.drawable.aos_im_e96)), TuplesKt.to("[祈祷]", Integer.valueOf(R.drawable.aos_im_e54)), TuplesKt.to("[看]", Integer.valueOf(R.drawable.aos_im_e74)), TuplesKt.to("[泣不成声]", Integer.valueOf(R.drawable.aos_im_e27)), TuplesKt.to("[赞]", Integer.valueOf(R.drawable.aos_im_e52))});
    }

    @JvmStatic
    public static final List<b> getEmojiList() {
        ArrayList r100 = new ArrayList();
        Map<String, Integer> r101 = DEFAULT_NAME_NAD_ID;
        ArrayList r102 = new ArrayList(r101.size());
        Iterator<Map.Entry<String, Integer>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, Integer> r104 = r103.next();
        b r105 = new b();
        r105.f511841c = r104.getKey();
        r105.f511839a = r104.getValue().intValue();
        r102.add(Boolean.valueOf(r100.add(r105)));
        goto L4
    L6:
        return r100;
    }

    @JvmStatic
    public static final List<b> getRecEmojiList() {
        ArrayList r100 = new ArrayList();
        List r101 = CollectionsKt.mutableListOf(new String[]{"[心]", "[玫瑰]", "[捂脸]", "[比心]", "[祈祷]", "[看]", "[泣不成声]", "[赞]"});
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = (String) r103.next();
        b r105 = new b();
        r105.f511841c = r104;
        Integer r106 = DEFAULT_NAME_NAD_ID.get(r104);
        Intrinsics.checkNotNull(r106);
        r105.f511839a = r106.intValue();
        r102.add(Boolean.valueOf(r100.add(r105)));
        goto L4
    L6:
        return r100;
    }

    @JvmStatic
    public static final Drawable getEmoji(String r100, Resources r101) {
        Intrinsics.checkNotNullParameter(r100, "string");
        Intrinsics.checkNotNullParameter(r101, "resources");
        Map<String, Integer> r102 = DEFAULT_NAME_NAD_ID;
        if (r102.containsKey(r100) == false) goto L8;
        Integer r103 = r102.get(r100);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r101.getDrawable(r103.intValue());
    L8:
        return null;
    }
}
