package com.lynx.animax.audio;

import android.media.AudioTrack;
import fna.g;
import gna.a;
import java.nio.ByteBuffer;
import org.bouncycastle.asn1.cmc.BodyPartID;
import p4a.c;
import p4a.d;
import p4a.e;

/* JADX INFO: loaded from: classes32.dex */
public class AudioPlayer implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f380249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f380250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuffer f380251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f380252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f380253e;

    public double getAudioTime() {
        long r100 = this.f380253e;
        d r101 = this.f380249a;
        long r102 = r100 + ((((long) r101.f527729f.getPlaybackHeadPosition()) & BodyPartID.bodyIdMax) * ((long) r101.f527725b));
        int r103 = this.f380252d;
        return (((r102 % ((long) r103)) / ((double) r103)) * this.f380250b.f527721d) / 1000.0d;
    }

    public double getDuration() {
        return this.f380250b.f527721d / 1000.0d;
    }

    public void pause() {
        AudioTrack r100 = this.f380249a.f527729f;
        if (g.d() == true) goto L5;
        r100.pause();
        return;
    L5:
        r100.pause();
        a.a(r100.hashCode());
    }

    public void play() {
        d r100 = this.f380249a;
        r100.onPeriodicNotification(r100.f527729f);
        AudioTrack r101 = r100.f527729f;
        if (g.d() == true) goto L5;
        r101.play();
        return;
    L5:
        r101.play();
        a.c(r101.hashCode());
    }

    public void seekToProgress(double r100) {
        d r101 = this.f380249a;
        AudioTrack r102 = r101.f527729f;
        if (g.d() == true) goto L5;
        r102.pause();
    L6:
        r101.f527729f.flush();
        r101.f527728e = 0;
        d r103 = this.f380249a;
        int r104 = (int) (r100 * ((double) this.f380252d));
        int r105 = r103.f527725b;
        this.f380253e = (r104 / r105) * r105;
        return;
    L5:
        r102.pause();
        a.a(r102.hashCode());
        goto L6
    }

    public AudioPlayer(c r100, ByteBuffer r101) {
        this.f380253e = 0;
        this.f380250b = r100;
        this.f380251c = r101;
        this.f380252d = r101.capacity();
        d r102 = new d(r100);
        this.f380249a = r102;
        r102.f527727d = this;
    }
}
