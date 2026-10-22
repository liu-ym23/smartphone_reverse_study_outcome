package com.ss.android.lark.message.card.style;

import com.larus.nova.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, C5133a> f431922a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.message.card.style.a$a, reason: collision with other inner class name */
    public static class C5133a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f431923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f431924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f431925c;

        public C5133a(int r100, int r101, int r102) {
            this.f431923a = r100;
            this.f431924b = r102;
            this.f431925c = r101;
        }
    }

    static {
        HashMap<String, C5133a> r100 = new HashMap();
        f431922a = r100;
        r100.put("blue", new C5133a(101, R.color.udtoken_message_card_text_blue, R.color.udtoken_message_card_bg_blue));
        r100.put("wathet", new C5133a(102, R.color.udtoken_message_card_text_wathet, R.color.udtoken_message_card_bg_wathet));
        r100.put("turquoise", new C5133a(103, R.color.udtoken_message_card_text_turquoise, R.color.udtoken_message_card_bg_turquoise));
        r100.put("green", new C5133a(104, R.color.udtoken_message_card_text_green, R.color.udtoken_message_card_bg_green));
        r100.put("lime", new C5133a(105, R.color.udtoken_message_card_text_lime, R.color.udtoken_message_card_bg_lime));
        r100.put("yellow", new C5133a(106, R.color.udtoken_message_card_text_yellow, R.color.udtoken_message_card_bg_yellow));
        r100.put("orange", new C5133a(107, R.color.udtoken_message_card_text_orange, R.color.udtoken_message_card_bg_orange));
        r100.put("red", new C5133a(108, R.color.udtoken_message_card_text_red, R.color.udtoken_message_card_bg_red));
        r100.put("carmine", new C5133a(109, R.color.udtoken_message_card_text_carmine, R.color.udtoken_message_card_bg_carmine));
        r100.put("violet", new C5133a(110, R.color.udtoken_message_card_text_violet, R.color.udtoken_message_card_bg_violet));
        r100.put("purple", new C5133a(111, R.color.udtoken_message_card_text_purple, R.color.udtoken_message_card_bg_purple));
        r100.put("indigo", new C5133a(112, R.color.udtoken_message_card_text_indigo, R.color.udtoken_message_card_bg_indigo));
        r100.put(com.bytedance.android.ec.core.event.a.VALUE_NEUTRAL, new C5133a(100, R.color.udtoken_message_card_text_neutral, R.color.udtoken_message_card_bg_neutral));
        r100.put("grey", new C5133a(100, R.color.udtoken_message_card_text_neutral, R.color.udtoken_message_card_bg_neutral));
        r100.put("gray", new C5133a(100, R.color.udtoken_message_card_text_neutral, R.color.udtoken_message_card_bg_neutral));
    }
}
