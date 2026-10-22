package com.obric.assistant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OUseMemorySettingsConfig f390022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<ComplexTaskSettingsCommonItem> f390023b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<ComplexTaskSettingsCommonItem> f390024c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ComplexTaskSettingsConfig f390025d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ObricSettingsListConfig f390026e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f390027f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<String> f390028g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<String> f390029h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ObricActionBarItemsConfig f390030i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ObricActionBarItemsConfig f390031j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ObricActionBarModelMenuConfig f390032k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ObricBottomTabConfig f390033l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ObricDeepThinkModeRestTimeConfig f390034m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final q1 f390035n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ObricAsrFeedbackConfig f390036o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ObricContTalkConfig f390037p = null;

    static {
        f390022a = new OUseMemorySettingsConfig(true);
        List<ComplexTaskSettingsCommonItem> r100 = CollectionsKt.listOf(new ComplexTaskSettingsCommonItem[]{new ComplexTaskSettingsCommonItem(1, "react", "React"), new ComplexTaskSettingsCommonItem(2, "planexecute", "Plan+execute")});
        f390023b = r100;
        List<ComplexTaskSettingsCommonItem> r101 = CollectionsKt.listOf(new ComplexTaskSettingsCommonItem[]{new ComplexTaskSettingsCommonItem(1, "gpt-41", "GPT-4.1"), new ComplexTaskSettingsCommonItem(2, "claude-37", "Claude-3.7"), new ComplexTaskSettingsCommonItem(3, "claude-4", "Claude-4"), new ComplexTaskSettingsCommonItem(4, "doubao-16-sft", "豆包模型 (Beta)")});
        f390024c = r101;
        f390025d = new ComplexTaskSettingsConfig("planexecute", "claude-37", r100, r101);
        f390026e = new ObricSettingsListConfig(null, null);
        List<String> r102 = CollectionsKt.listOf(new String[]{"11757434315683330", "295367523", "1890683158", "780021240", "-761162256", "1439177079459842", "261510651735810", "261510651736322", "261510651731202", "11757415837603330", "261510651733762", "261510651740418", "857401409443330", "3104653159767042", "261510651737858", "261510651739906", "21554838808483330", "261510651730434", "6158051860028162", "261510651732994", "241623133", "596623375", "-92001", "40171075925118466"});
        f390027f = r102;
        f390028g = CollectionsKt.listOf(new String[]{"295367523", "1890683158", "780021240", "-761162256", "241623133", "1439177079459842", "596623375", "-92001", "40171075925118466", "-93000"});
        f390029h = CollectionsKt.listOf("13090563690403330");
        List<String> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(new q0((String) r105.next()));
        goto L4
    L6:
        f390030i = new ObricActionBarItemsConfig(null, r104, 1, null);
        List<String> r106 = f390028g;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        r107.add(new q0((String) r108.next()));
        goto L8
    L10:
        f390031j = new ObricActionBarItemsConfig(null, r107, 1, null);
        f390032k = new ObricActionBarModelMenuConfig(Boolean.TRUE, CollectionsKt.listOf(new Integer[]{2, 3, 10000, 100001}), 4);
        f390033l = new ObricBottomTabConfig(null, null, null, 7, null);
        f390034m = new ObricDeepThinkModeRestTimeConfig(1200000L);
        Boolean r109 = Boolean.FALSE;
        f390035n = new q1(r109);
        f390036o = new ObricAsrFeedbackConfig(r109);
        f390037p = new ObricContTalkConfig(r109);
    }
}
