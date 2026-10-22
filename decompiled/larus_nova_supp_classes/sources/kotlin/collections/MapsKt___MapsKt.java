package kotlin.collections;

import android.Manifest;
import android.util.EventsUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aJ\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a9\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001a6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001a'\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001aJ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a[\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a]\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\\\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\bø\u0001\u0000\u001aa\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0017\u001au\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aw\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001c\u001aJ\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\bø\u0001\u0000\u001aV\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\bø\u0001\u0000\u001a\\\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\bø\u0001\u0000\u001au\u0010#\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ao\u0010$\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ak\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b(\u001ah\u0010)\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000\u001a_\u0010*\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aJ\u0010*\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000\u001aJ\u0010*\u001a\u00020-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\bø\u0001\u0000\u001aa\u0010.\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u0010.\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aQ\u0010.\u001a\u0004\u0018\u00010-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00100\u001aq\u00101\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001as\u00106\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001al\u00107\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b¢\u0006\u0002\b8\u001ai\u00109\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b\u001ak\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b;\u001ah\u0010<\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000\u001a_\u0010=\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aJ\u0010=\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000\u001aJ\u0010=\u001a\u00020-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\bø\u0001\u0000\u001aa\u0010>\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u0010>\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aQ\u0010>\u001a\u0004\u0018\u00010-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00100\u001aq\u0010?\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001as\u0010@\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001al\u0010A\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b¢\u0006\u0002\bB\u001ai\u0010C\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b\u001a$\u0010D\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010D\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001aY\u0010E\u001a\u0002HF\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010F*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HF2\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010G\u001an\u0010H\u001a\u0002HF\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010F*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HF23\u0010 \u001a/\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0IH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010M\u001a6\u0010N\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030O0\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006P"}, d2 = {"all", XmlPullParser.NO_NAMESPACE, "K", "V", XmlPullParser.NO_NAMESPACE, "predicate", "Lkotlin/Function1;", XmlPullParser.NO_NAMESPACE, "any", "asIterable", XmlPullParser.NO_NAMESPACE, "asSequence", "Lkotlin/sequences/Sequence;", "count", XmlPullParser.NO_NAMESPACE, "firstNotNullOf", "R", XmlPullParser.NO_NAMESPACE, "transform", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "flatMap", XmlPullParser.NO_NAMESPACE, "flatMapSequence", "flatMapTo", "C", XmlPullParser.NO_NAMESPACE, "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "forEach", XmlPullParser.NO_NAMESPACE, "action", "map", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", XmlPullParser.NO_NAMESPACE, "selector", "maxByOrThrow", "maxByOrNull", "maxOf", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrThrow", "maxWithOrNull", "minBy", "minByOrThrow", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrThrow", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/collections/MapsKt")
class MapsKt___MapsKt extends MapsKt___MapsJvmKt {
    public MapsKt___MapsKt() {
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !r1.isEmpty();
    }

    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.entrySet();
    }

    public static <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return CollectionsKt.asSequence(r1.entrySet());
    }

    private static final <K, V> int count(Map<? extends K, ? extends V> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.isEmpty();
    }

    public static <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.size() == 0) goto L5;
        Iterator<Map.Entry<? extends K, ? extends V>> r0 = r4.entrySet().iterator();
        if (r0.hasNext() == false) goto L9;
        Map.Entry<? extends K, ? extends V> r1 = r0.next();
        if (r0.hasNext() == false) goto L13;
        ArrayList r2 = new ArrayList(r4.size());
        r2.add(new Pair(r1.getKey(), r1.getValue()));
    L15:
        Map.Entry<? extends K, ? extends V> r5 = r0.next();
        r2.add(new Pair(r5.getKey(), r5.getValue()));
        if (r0.hasNext() == true) goto L15;
        return r2;
    L13:
        return CollectionsKt.listOf(new Pair(r1.getKey(), r1.getValue()));
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public static final <K, V> boolean all(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        if (r2.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r2.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (r3.invoke(r4.next()).booleanValue() == true) goto L7;
        return false;
    L12:
        return true;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        if (r2.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r2.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (r3.invoke(r4.next()).booleanValue() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public static final <K, V> int count(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        int r1 = 0;
        if (r2.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r2.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (r3.invoke(r4.next()).booleanValue() == false) goto L7;
        r1 = r1 + 1;
        goto L7
    L11:
        return r1;
    }

    private static final <K, V, R> R firstNotNullOf(Map<? extends K, ? extends V> r1, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        R r0 = r2.invoke(r3.next());
        if (r0 == null) goto L4;
    L9:
        if (r0 == null) goto L12;
        return r0;
    L12:
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    L8:
        r0 = null;
        goto L9
    }

    private static final <K, V, R> R firstNotNullOfOrNull(Map<? extends K, ? extends V> r1, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        R r0 = r2.invoke(r3.next());
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public static final <K, V, R> List<R> flatMap(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "transform");
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, r3.invoke(r4.next()));
        goto L4
    L6:
        return r0;
    }

    public static final <K, V, R> List<R> flatMapSequence(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "transform");
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, r3.invoke(r4.next()));
        goto L4
    L6:
        return r0;
    }

    public static final <K, V> void forEach(Map<? extends K, ? extends V> r1, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.invoke(r3.next());
        goto L4
    }

    public static final <K, V, R> List<R> map(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "transform");
        ArrayList r0 = new ArrayList(r2.size());
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(r3.invoke(r4.next()));
        goto L4
    L6:
        return r0;
    }

    public static final <K, V, R> List<R> mapNotNull(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "transform");
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        R r1 = r3.invoke(r4.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(Map<? extends K, ? extends V> r5, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "selector");
        Iterator<T> r7 = r5.entrySet().iterator();
        if (r7.hasNext() == true) goto L5;
        Map.Entry<K, V> r8 = null;
    L16:
        return r8;
    L5:
        Map.Entry<K, V> r0 = (Object) r7.next();
        if (r7.hasNext() == true) goto L8;
    L7:
        r8 = r0;
        goto L16
    L8:
        R r1 = r6.invoke(r0);
    L9:
        Map.Entry<K, V> r2 = (Object) r7.next();
        R r3 = r6.invoke(r2);
        if (r1.compareTo(r3) >= 0) goto L13;
        r0 = r2;
        r1 = r3;
    L13:
        if (r7.hasNext() == true) goto L9;
        goto L7
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrThrow(Map<? extends K, ? extends V> r5, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "selector");
        Iterator<T> r7 = r5.entrySet().iterator();
        if (r7.hasNext() == false) goto L16;
        Map.Entry<K, V> r0 = (Object) r7.next();
        if (r7.hasNext() == false) goto L14;
        R r1 = r6.invoke(r0);
    L8:
        Map.Entry<K, V> r2 = (Object) r7.next();
        R r3 = r6.invoke(r2);
        if (r1.compareTo(r3) >= 0) goto L12;
        r0 = r2;
        r1 = r3;
    L12:
        if (r7.hasNext() == true) goto L8;
    L14:
        return r0;
    L16:
        throw new NoSuchElementException();
    }

    private static final <K, V> double maxOf(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "selector");
        Iterator<T> r6 = r4.entrySet().iterator();
        if (r6.hasNext() == false) goto L10;
        double r0 = r5.invoke((Object) r6.next()).doubleValue();
    L6:
        if (r6.hasNext() == false) goto L8;
        r0 = Math.max(r0, r5.invoke((Object) r6.next()).doubleValue());
        goto L6
    L8:
        return r0;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <K, V> Double m158maxOfOrNull(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "selector");
        Iterator<T> r6 = r4.entrySet().iterator();
        if (r6.hasNext() == true) goto L5;
        return null;
    L5:
        double r0 = r5.invoke((Object) r6.next()).doubleValue();
    L7:
        if (r6.hasNext() == false) goto L10;
        r0 = Math.max(r0, r5.invoke((Object) r6.next()).doubleValue());
        goto L7
    L10:
        return Double.valueOf(r0);
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrNull(Map<? extends K, ? extends V> r1, Comparator<? super Map.Entry<? extends K, ? extends V>> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return (Map.Entry) CollectionsKt.maxWithOrNull(r1.entrySet(), r2);
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrThrow(Map<? extends K, ? extends V> r1, Comparator<? super Map.Entry<? extends K, ? extends V>> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.maxWithOrThrow(r1.entrySet(), r2);
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(Map<? extends K, ? extends V> r5, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "selector");
        Iterator<T> r7 = r5.entrySet().iterator();
        if (r7.hasNext() == true) goto L5;
        Map.Entry<K, V> r8 = null;
    L16:
        return r8;
    L5:
        Map.Entry<K, V> r0 = (Object) r7.next();
        if (r7.hasNext() == true) goto L8;
    L7:
        r8 = r0;
        goto L16
    L8:
        R r1 = r6.invoke(r0);
    L9:
        Map.Entry<K, V> r2 = (Object) r7.next();
        R r3 = r6.invoke(r2);
        if (r1.compareTo(r3) <= 0) goto L13;
        r0 = r2;
        r1 = r3;
    L13:
        if (r7.hasNext() == true) goto L9;
        goto L7
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrThrow(Map<? extends K, ? extends V> r5, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "selector");
        Iterator<T> r7 = r5.entrySet().iterator();
        if (r7.hasNext() == false) goto L16;
        Map.Entry<K, V> r0 = (Object) r7.next();
        if (r7.hasNext() == false) goto L14;
        R r1 = r6.invoke(r0);
    L8:
        Map.Entry<K, V> r2 = (Object) r7.next();
        R r3 = r6.invoke(r2);
        if (r1.compareTo(r3) <= 0) goto L12;
        r0 = r2;
        r1 = r3;
    L12:
        if (r7.hasNext() == true) goto L8;
    L14:
        return r0;
    L16:
        throw new NoSuchElementException();
    }

    private static final <K, V> double minOf(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "selector");
        Iterator<T> r6 = r4.entrySet().iterator();
        if (r6.hasNext() == false) goto L10;
        double r0 = r5.invoke((Object) r6.next()).doubleValue();
    L6:
        if (r6.hasNext() == false) goto L8;
        r0 = Math.min(r0, r5.invoke((Object) r6.next()).doubleValue());
        goto L6
    L8:
        return r0;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <K, V> Double m162minOfOrNull(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "selector");
        Iterator<T> r6 = r4.entrySet().iterator();
        if (r6.hasNext() == true) goto L5;
        return null;
    L5:
        double r0 = r5.invoke((Object) r6.next()).doubleValue();
    L7:
        if (r6.hasNext() == false) goto L10;
        r0 = Math.min(r0, r5.invoke((Object) r6.next()).doubleValue());
        goto L7
    L10:
        return Double.valueOf(r0);
    }

    private static final <K, V> Map.Entry<K, V> minWithOrNull(Map<? extends K, ? extends V> r1, Comparator<? super Map.Entry<? extends K, ? extends V>> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return (Map.Entry) CollectionsKt.minWithOrNull(r1.entrySet(), r2);
    }

    private static final <K, V> Map.Entry<K, V> minWithOrThrow(Map<? extends K, ? extends V> r1, Comparator<? super Map.Entry<? extends K, ? extends V>> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.minWithOrThrow(r1.entrySet(), r2);
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        if (r2.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r2.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (r3.invoke(r4.next()).booleanValue() == false) goto L7;
        return false;
    L12:
        return true;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(M r2, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "action");
        Iterator<Map.Entry<K, V>> r0 = r2.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke(r0.next());
        goto L4
    L6:
        return r2;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(M r4, Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "action");
        Iterator<T> r0 = r4.entrySet().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Manifest.permission_group r2 = (Object) r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r5.invoke(Integer.valueOf(r1), r2);
        r1 = r3;
        goto L4
    L9:
        return r4;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <K, V> float m156maxOf(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "selector");
        Iterator<T> r4 = r2.entrySet().iterator();
        if (r4.hasNext() == false) goto L10;
        float r0 = r3.invoke((Object) r4.next()).floatValue();
    L6:
        if (r4.hasNext() == false) goto L8;
        r0 = Math.max(r0, r3.invoke((Object) r4.next()).floatValue());
        goto L6
    L8:
        return r0;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <K, V> Float m159maxOfOrNull(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "selector");
        Iterator<T> r4 = r2.entrySet().iterator();
        if (r4.hasNext() == true) goto L5;
        return null;
    L5:
        float r0 = r3.invoke((Object) r4.next()).floatValue();
    L7:
        if (r4.hasNext() == false) goto L10;
        r0 = Math.max(r0, r3.invoke((Object) r4.next()).floatValue());
        goto L7
    L10:
        return Float.valueOf(r0);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <K, V> float m160minOf(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "selector");
        Iterator<T> r4 = r2.entrySet().iterator();
        if (r4.hasNext() == false) goto L10;
        float r0 = r3.invoke((Object) r4.next()).floatValue();
    L6:
        if (r4.hasNext() == false) goto L8;
        r0 = Math.min(r0, r3.invoke((Object) r4.next()).floatValue());
        goto L6
    L8:
        return r0;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <K, V> Float m163minOfOrNull(Map<? extends K, ? extends V> r2, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "selector");
        Iterator<T> r4 = r2.entrySet().iterator();
        if (r4.hasNext() == true) goto L5;
        return null;
    L5:
        float r0 = r3.invoke((Object) r4.next()).floatValue();
    L7:
        if (r4.hasNext() == false) goto L10;
        r0 = Math.min(r0, r3.invoke((Object) r4.next()).floatValue());
        goto L7
    L10:
        return Float.valueOf(r0);
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <K, V, R extends Comparable<? super R>> R m157maxOf(Map<? extends K, ? extends V> r3, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "selector");
        Iterator<T> r5 = r3.entrySet().iterator();
        if (r5.hasNext() == false) goto L12;
        R r0 = r4.invoke((Object) r5.next());
    L6:
        if (r5.hasNext() == false) goto L10;
        R r1 = r4.invoke((Object) r5.next());
        if (r0.compareTo(r1) >= 0) goto L6;
        r0 = r1;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    private static final <K, V, R extends Comparable<? super R>> R maxOfOrNull(Map<? extends K, ? extends V> r3, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "selector");
        Iterator<T> r5 = r3.entrySet().iterator();
        if (r5.hasNext() == true) goto L5;
        return null;
    L5:
        R r0 = r4.invoke((Object) r5.next());
    L7:
        if (r5.hasNext() == false) goto L12;
        R r1 = r4.invoke((Object) r5.next());
        if (r0.compareTo(r1) >= 0) goto L7;
        r0 = r1;
        goto L7
    L12:
        return r0;
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <K, V, R extends Comparable<? super R>> R m161minOf(Map<? extends K, ? extends V> r3, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "selector");
        Iterator<T> r5 = r3.entrySet().iterator();
        if (r5.hasNext() == false) goto L12;
        R r0 = r4.invoke((Object) r5.next());
    L6:
        if (r5.hasNext() == false) goto L10;
        R r1 = r4.invoke((Object) r5.next());
        if (r0.compareTo(r1) <= 0) goto L6;
        r0 = r1;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    private static final <K, V, R extends Comparable<? super R>> R minOfOrNull(Map<? extends K, ? extends V> r3, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "selector");
        Iterator<T> r5 = r3.entrySet().iterator();
        if (r5.hasNext() == true) goto L5;
        return null;
    L5:
        R r0 = r4.invoke((Object) r5.next());
    L7:
        if (r5.hasNext() == false) goto L12;
        R r1 = r4.invoke((Object) r5.next());
        if (r0.compareTo(r1) <= 0) goto L7;
        r0 = r1;
        goto L7
    L12:
        return r0;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(Map<? extends K, ? extends V> r1, C r2, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        Intrinsics.checkNotNullParameter(r3, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r1.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        CollectionsKt.addAll(r2, r3.invoke(r4.next()));
        goto L4
    L6:
        return r2;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(Map<? extends K, ? extends V> r1, C r2, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        Intrinsics.checkNotNullParameter(r3, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r1.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        CollectionsKt.addAll(r2, r3.invoke(r4.next()));
        goto L4
    L6:
        return r2;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(Map<? extends K, ? extends V> r1, C r2, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        Intrinsics.checkNotNullParameter(r3, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r1.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        R r0 = r3.invoke(r4.next());
        if (r0 == null) goto L4;
        r2.add(r0);
        goto L4
    L8:
        return r2;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapTo(Map<? extends K, ? extends V> r1, C r2, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        Intrinsics.checkNotNullParameter(r3, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r1.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r2.add(r3.invoke(r4.next()));
        goto L4
    L6:
        return r2;
    }

    private static final <K, V, R> R maxOfWith(Map<? extends K, ? extends V> r3, Comparator<? super R> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        Intrinsics.checkNotNullParameter(r5, "selector");
        Iterator<T> r6 = r3.entrySet().iterator();
        if (r6.hasNext() == false) goto L12;
        R r0 = r5.invoke((Object) r6.next());
    L6:
        if (r6.hasNext() == false) goto L10;
        R r1 = r5.invoke((Object) r6.next());
        if (r4.compare(r0, r1) >= 0) goto L6;
        r0 = r1;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    private static final <K, V, R> R maxOfWithOrNull(Map<? extends K, ? extends V> r3, Comparator<? super R> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        Intrinsics.checkNotNullParameter(r5, "selector");
        Iterator<T> r6 = r3.entrySet().iterator();
        if (r6.hasNext() == true) goto L5;
        return null;
    L5:
        R r0 = r5.invoke((Object) r6.next());
    L7:
        if (r6.hasNext() == false) goto L12;
        R r1 = r5.invoke((Object) r6.next());
        if (r4.compare(r0, r1) >= 0) goto L7;
        r0 = (Object) r1;
        goto L7
    L12:
        return r0;
    }

    private static final <K, V, R> R minOfWith(Map<? extends K, ? extends V> r3, Comparator<? super R> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        Intrinsics.checkNotNullParameter(r5, "selector");
        Iterator<T> r6 = r3.entrySet().iterator();
        if (r6.hasNext() == false) goto L12;
        R r0 = r5.invoke((Object) r6.next());
    L6:
        if (r6.hasNext() == false) goto L10;
        R r1 = r5.invoke((Object) r6.next());
        if (r4.compare(r0, r1) <= 0) goto L6;
        r0 = r1;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    private static final <K, V, R> R minOfWithOrNull(Map<? extends K, ? extends V> r3, Comparator<? super R> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        Intrinsics.checkNotNullParameter(r5, "selector");
        Iterator<T> r6 = r3.entrySet().iterator();
        if (r6.hasNext() == true) goto L5;
        return null;
    L5:
        R r0 = r5.invoke((Object) r6.next());
    L7:
        if (r6.hasNext() == false) goto L12;
        R r1 = r5.invoke((Object) r6.next());
        if (r4.compare(r0, r1) <= 0) goto L7;
        r0 = (Object) r1;
        goto L7
    L12:
        return r0;
    }
}
