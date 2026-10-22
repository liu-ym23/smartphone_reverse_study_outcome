package k2c;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f501627a = null;

    static {
        HashMap r100 = new HashMap(256);
        f501627a = r100;
        r100.put("SMILE", Integer.valueOf(R.drawable.emoji_smile));
        r100.put("DROOL", Integer.valueOf(R.drawable.emoji_drool));
        r100.put("SCOWL", Integer.valueOf(R.drawable.emoji_scowl));
        r100.put("HAUGHTY", Integer.valueOf(R.drawable.emoji_irritated));
        r100.put("NOSEPICK", Integer.valueOf(R.drawable.emoji_nosepick));
        r100.put("SOB", Integer.valueOf(R.drawable.emoji_sob));
        r100.put("ANGRY", Integer.valueOf(R.drawable.emoji_angry));
        r100.put("BLUSH", Integer.valueOf(R.drawable.emoji_grin));
        r100.put("SLEEP", Integer.valueOf(R.drawable.emoji_sleep));
        r100.put("SHY", Integer.valueOf(R.drawable.emoji_shy));
        r100.put("WINK", Integer.valueOf(R.drawable.emoji_wink));
        r100.put("DIZZY", Integer.valueOf(R.drawable.emoji_dizzy));
        r100.put("TOASTED", Integer.valueOf(R.drawable.emoji_toasted));
        r100.put("SILENT", Integer.valueOf(R.drawable.emoji_silent));
        r100.put("SMART", Integer.valueOf(R.drawable.emoji_smart));
        r100.put("ATTENTION", Integer.valueOf(R.drawable.emoji_attention));
        r100.put("WITTY", Integer.valueOf(R.drawable.emoji_witty));
        r100.put("YEAH", Integer.valueOf(R.drawable.emoji_yeah));
        r100.put("FACEPALM", Integer.valueOf(R.drawable.emoji_facepalm));
        r100.put("SLAP", Integer.valueOf(R.drawable.emoji_slap));
        r100.put("LAUGH", Integer.valueOf(R.drawable.emoji_laugh));
        r100.put("YAWN", Integer.valueOf(R.drawable.emoji_yawn));
        r100.put("SHOCKED", Integer.valueOf(R.drawable.emoji_shocked));
        r100.put("LOVE", Integer.valueOf(R.drawable.emoji_love));
        r100.put("DROWSY", Integer.valueOf(R.drawable.emoji_drowsy));
        r100.put("WHAT", Integer.valueOf(R.drawable.emoji_what));
        r100.put("CRY", Integer.valueOf(R.drawable.emoji_cry));
        r100.put("CLAP", Integer.valueOf(R.drawable.emoji_clap));
        r100.put("SHOWOFF", Integer.valueOf(R.drawable.emoji_showoff));
        r100.put("CHUCKLE", Integer.valueOf(R.drawable.emoji_chuckle));
        r100.put("PETRIFIED", Integer.valueOf(R.drawable.emoji_petrified));
        r100.put("THINKING", Integer.valueOf(R.drawable.emoji_thinking));
        r100.put("SPITBLOOD", Integer.valueOf(R.drawable.emoji_spitblood));
        r100.put("WHIMPER", Integer.valueOf(R.drawable.emoji_whimper));
        r100.put("SHHH", Integer.valueOf(R.drawable.emoji_shhh));
        r100.put("SMUG", Integer.valueOf(R.drawable.emoji_smug));
        r100.put("ERROR", Integer.valueOf(R.drawable.emoji_errr));
        r100.put("LOL", Integer.valueOf(R.drawable.emoji_lol));
        r100.put("SICK", Integer.valueOf(R.drawable.emoji_sick));
        r100.put("SMIRK", Integer.valueOf(R.drawable.emoji_smirk));
        r100.put("PROUD", Integer.valueOf(R.drawable.emoji_proud));
        r100.put("TRICK", Integer.valueOf(R.drawable.emoji_trick));
        r100.put("CRAZY", Integer.valueOf(R.drawable.emoji_crazy));
        r100.put("TEARS", Integer.valueOf(R.drawable.emoji_tears));
        r100.put("MONEY", Integer.valueOf(R.drawable.emoji_money));
        r100.put("KISS", Integer.valueOf(R.drawable.emoji_kiss));
        r100.put("TERROR", Integer.valueOf(R.drawable.emoji_terror));
        r100.put("JOYFUL", Integer.valueOf(R.drawable.emoji_joyful));
        r100.put("BLUBBER", Integer.valueOf(R.drawable.emoji_blubber));
        r100.put("HUSKY", Integer.valueOf(R.drawable.emoji_husky));
        r100.put("FOLLOWME", Integer.valueOf(R.drawable.emoji_followme));
        r100.put("THUMBSUP", Integer.valueOf(R.drawable.emoji_thumbsup));
        r100.put("APPLAUSE", Integer.valueOf(R.drawable.emoji_applaud));
        r100.put("THANKS", Integer.valueOf(R.drawable.emoji_thanks));
        r100.put("MUSCLE", Integer.valueOf(R.drawable.emoji_fighting));
        r100.put("OK", Integer.valueOf(R.drawable.emoji_ok));
        r100.put("HEART", Integer.valueOf(R.drawable.emoji_heart));
        r100.put("LIPS", Integer.valueOf(R.drawable.emoji_lips));
        r100.put("DETERGENT", Integer.valueOf(R.drawable.emoji_detergent));
        r100.put("AWESOME", Integer.valueOf(R.drawable.emoji_awesome));
        r100.put("ROSE", Integer.valueOf(R.drawable.emoji_rose));
        r100.put("CUCUMBER", Integer.valueOf(R.drawable.emoji_cucumber));
        r100.put("BEER", Integer.valueOf(R.drawable.emoji_beer));
        r100.put("ENOUGH", Integer.valueOf(R.drawable.emoji_enough));
        r100.put("WRONGED", Integer.valueOf(R.drawable.emoji_wronged));
        r100.put("OBSESSED", Integer.valueOf(R.drawable.emoji_obsessed));
        r100.put("LOOKDOWN", Integer.valueOf(R.drawable.emoji_lookdown));
        r100.put("SMOOCH", Integer.valueOf(R.drawable.emoji_smooch));
        r100.put("WAVE", Integer.valueOf(R.drawable.emoji_wave));
        r100.put("DONNOTGO", Integer.valueOf(R.drawable.emoji_donnotgo));
        r100.put("HEADSET", Integer.valueOf(R.drawable.emoji_headset));
        r100.put("HUG", Integer.valueOf(R.drawable.emoji_hug));
        r100.put("DULLSTARE", Integer.valueOf(R.drawable.emoji_dullstare));
        r100.put("INNOCENTSMILE", Integer.valueOf(R.drawable.emoji_innocentsmile));
        r100.put("TONGUE", Integer.valueOf(R.drawable.emoji_tongue));
        r100.put("DULL", Integer.valueOf(R.drawable.emoji_dull));
        r100.put("GLANCE", Integer.valueOf(R.drawable.emoji_glance));
        r100.put("SLIGHT", Integer.valueOf(R.drawable.emoji_slight));
        r100.put("BEAR", Integer.valueOf(R.drawable.emoji_bear));
        r100.put("SKULL", Integer.valueOf(R.drawable.emoji_skull));
        r100.put("BLACKFACE", Integer.valueOf(R.drawable.emoji_blackface));
        r100.put("EATING", Integer.valueOf(R.drawable.emoji_eating));
        r100.put("BETRAYED", Integer.valueOf(R.drawable.emoji_betrayed));
        r100.put("SWEAT", Integer.valueOf(R.drawable.emoji_sweat));
        r100.put("COMFORT", Integer.valueOf(R.drawable.emoji_comfort));
        r100.put("FROWN", Integer.valueOf(R.drawable.emoji_frown));
        r100.put("SPEECHLESS", Integer.valueOf(R.drawable.emoji_speechless));
        r100.put("XBLUSH", Integer.valueOf(R.drawable.emoji_blush));
        r100.put("EMBARRASSED", Integer.valueOf(R.drawable.emoji_embarrassed));
        r100.put("TEASE", Integer.valueOf(R.drawable.emoji_tease));
        r100.put("PRAISE", Integer.valueOf(R.drawable.emoji_praise));
        r100.put("BIGKISS", Integer.valueOf(R.drawable.emoji_bigkiss));
        r100.put("PUKE", Integer.valueOf(R.drawable.emoji_puke));
        r100.put("WOW", Integer.valueOf(R.drawable.emoji_wow));
        r100.put("HAMMER", Integer.valueOf(R.drawable.emoji_hammer_v1));
        r100.put("STRIVE", Integer.valueOf(R.drawable.emoji_strive));
        r100.put("RAINBOWPUKE", Integer.valueOf(R.drawable.emoji_rainbowpuke));
        r100.put("WAIL", Integer.valueOf(R.drawable.emoji_wail));
        r100.put("FINGERHEART", Integer.valueOf(R.drawable.emoji_fingerheart));
        r100.put("FISTBUMP", Integer.valueOf(R.drawable.emoji_fistbump));
        r100.put("HIGHFIVE", Integer.valueOf(R.drawable.emoji_highfive));
        r100.put("UPPERLEFT", Integer.valueOf(R.drawable.emoji_click_v2));
        r100.put("SHAKE", Integer.valueOf(R.drawable.emoji_shake));
        r100.put("SALUTE", Integer.valueOf(R.drawable.emoji_salute));
        r100.put("DONE", Integer.valueOf(R.drawable.emoji_done));
        r100.put("18X", Integer.valueOf(R.drawable.emoji_eighteen));
        r100.put("CLEAVER", Integer.valueOf(R.drawable.emoji_cleaver_v3));
        r100.put("JIAYI", Integer.valueOf(R.drawable.emoji_plusone));
        r100.put("WELLDONE", Integer.valueOf(R.drawable.emoji_welldone));
        r100.put("GOODJOB", Integer.valueOf(R.drawable.emoji_goodjob));
        r100.put("HEARTBROKEN", Integer.valueOf(R.drawable.emoji_heartbroken));
        r100.put("POOP", Integer.valueOf(R.drawable.emoji_poop));
        r100.put("GIFT", Integer.valueOf(R.drawable.emoji_gift));
        r100.put("CAKE", Integer.valueOf(R.drawable.emoji_cake));
        r100.put("PARTY", Integer.valueOf(R.drawable.emoji_party));
        r100.put("EYESCLOSED", Integer.valueOf(R.drawable.emoji_eyesclosed));
        r100.put("BOMB", Integer.valueOf(R.drawable.emoji_bomb));
        r100.put("FIREWORKS", Integer.valueOf(R.drawable.emoji_fireworks));
        r100.put("BULL", Integer.valueOf(R.drawable.emoji_bull));
        r100.put("CALF", Integer.valueOf(R.drawable.emoji_calf));
        r100.put("AWESOMEN", Integer.valueOf(R.drawable.emoji_awesomen));
        r100.put("2021", Integer.valueOf(R.drawable.emoji_twentytwentyone));
        r100.put("CANDIEDHAWS", Integer.valueOf(R.drawable.emoji_candiedhaws));
        r100.put("REDPACKET", Integer.valueOf(R.drawable.emoji_redpacket));
        r100.put("FORTUNE", Integer.valueOf(R.drawable.emoji_fortune));
        r100.put("LUCK", Integer.valueOf(R.drawable.emoji_luck));
        r100.put("FIRECRACKER", Integer.valueOf(R.drawable.emoji_firecracker));
        r100.put("EatingFood", Integer.valueOf(R.drawable.emoji_eatingfood));
        r100.put("Typing", Integer.valueOf(R.drawable.emoji_typing));
        r100.put("Lemon", Integer.valueOf(R.drawable.emoji_lemon));
        r100.put("Get", Integer.valueOf(R.drawable.emoji_get_v3));
        r100.put("LGTM", Integer.valueOf(R.drawable.emoji_lgtm));
        r100.put("ThumbsDown", Integer.valueOf(R.drawable.emoji_thumbsdown));
        r100.put("Drumstick", Integer.valueOf(R.drawable.emoji_drumstick));
        r100.put("Pepper", Integer.valueOf(R.drawable.emoji_pepper));
        r100.put("BubbleTea", Integer.valueOf(R.drawable.emoji_bubbletea));
        r100.put("Coffee", Integer.valueOf(R.drawable.emoji_coffee));
        r100.put("Yes", Integer.valueOf(R.drawable.emoji_yes));
        r100.put("No", Integer.valueOf(R.drawable.emoji_no_v3));
        r100.put("OKR", Integer.valueOf(R.drawable.emoji_okr));
        r100.put("CheckMark", Integer.valueOf(R.drawable.emoji_checkmark));
        r100.put("CrossMark", Integer.valueOf(R.drawable.emoji_crossmark));
        r100.put("MinusOne", Integer.valueOf(R.drawable.emoji_minusone));
        r100.put("Hundred", Integer.valueOf(R.drawable.emoji_hundred));
        r100.put(WikiFolderPushPlugin.PIN, Integer.valueOf(R.drawable.emoji_pin));
        r100.put("Alarm", Integer.valueOf(R.drawable.emoji_alarm));
        r100.put("Loudspeaker", Integer.valueOf(R.drawable.emoji_loudspeaker));
        r100.put("Trophy", Integer.valueOf(R.drawable.emoji_trophy));
        r100.put("Fire", Integer.valueOf(R.drawable.emoji_fire));
        r100.put("Music", Integer.valueOf(R.drawable.emoji_music));
    }

    public static int a(String r100) {
        ConcurrentHashMap<String, qsb.a> r101 = qsb.b.a().Q1();
        if (r101.containsKey(r100) == true) goto L5;
        return 32;
    L5:
        return r101.get(r100).a();
    }

    public static int b(String r100) {
        ConcurrentHashMap<String, qsb.a> r101 = qsb.b.a().Q1();
        if (r101.containsKey(r100) == true) goto L5;
        return 32;
    L5:
        return r101.get(r100).c();
    }
}
