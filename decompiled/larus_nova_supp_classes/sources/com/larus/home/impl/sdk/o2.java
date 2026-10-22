package com.larus.home.impl.sdk;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.EventsUtils;
import android.view.View;
import au9.g;
import bu9.i;
import com.bytedance.news.common.settings.SettingsManager;
import com.google.gson.Gson;
import com.larus.abtest.api.IAbTest;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.community.api.ICommunityService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraServiceImpl$otaNewVersionChangedFlow$;
import com.larus.im.bean.message.block.Block;
import com.larus.minor.api.IMinorService;
import com.larus.network.HttpConst;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.api.m3;
import com.larus.platform.model.AigcMetadataConfig;
import com.larus.platform.model.AudioDebugConfig;
import com.larus.platform.model.ExportFileConfig;
import com.larus.platform.model.FlowMarkdownSettings;
import com.larus.platform.model.GlobalFeedbackConfig;
import com.larus.platform.model.HandsfreeExperimentConfig;
import com.larus.platform.model.HoverActionConfig;
import com.larus.platform.model.InputComponentConfig;
import com.larus.platform.model.KmpInstructionCoreOptConfig;
import com.larus.platform.model.MarkDownSelectorSettings;
import com.larus.platform.model.MessageActionConfig;
import com.larus.platform.model.MessageMarkdownSettingsConfig;
import com.larus.platform.model.ProfileLikeCollectListConfig;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.model.SpeakStyleConfig;
import com.larus.platform.model.album.FastSendFromCameraScene;
import com.larus.platform.model.album.FastSendFromShowType;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.model.audio.ASRStrengthenConfig;
import com.larus.platform.model.audio.AudioConnectionPoolConfig;
import com.larus.platform.model.audio.AudioFeedbackFrequencyConfig;
import com.larus.platform.model.audio.AudioFeedbackSwitch;
import com.larus.platform.model.audio.AudioHostConfig;
import com.larus.platform.model.audio.AudioPendingWaitConfig;
import com.larus.platform.model.audio.AudioRetransmitStrategyModel;
import com.larus.platform.model.audio.AudioSyncCallConfig;
import com.larus.platform.model.audio.AutoReadTtsOptConfig;
import com.larus.platform.model.audio.CloseAudioConnectionAppBackgroundConfig;
import com.larus.platform.model.audio.ContinuousSpeechUIConfig;
import com.larus.platform.model.audio.FlowDoraSamiConfigModel;
import com.larus.platform.model.audio.GuideConfig;
import com.larus.platform.model.audio.OboeOptConfig;
import com.larus.platform.model.audio.RealtimeCallAddEventConfig;
import com.larus.platform.model.audio.RealtimeCallBtnPositionConfig;
import com.larus.platform.model.audio.RealtimeCallHelloConfig;
import com.larus.platform.model.audio.RealtimeCallSceneConfig;
import com.larus.platform.model.audio.RealtimeCallSceneModeConfig;
import com.larus.platform.model.audio.RealtimeCallSceneModeHelloConfig;
import com.larus.platform.model.audio.RealtimeSuggestUIConfig;
import com.larus.platform.model.audio.SimultaneousInterpretationClientConfig;
import com.larus.platform.model.audio.TtsOpenGuideConfig;
import com.larus.platform.model.audio.VoiceRecommendConfig;
import com.larus.platform.model.bot.MultiBotsCapability;
import com.larus.platform.model.bot.MultiBotsStatusUIFixConfig;
import com.larus.platform.model.camera.AppImageAutoOptConfig;
import com.larus.platform.model.camera.AppImageUploadPerfOptConf;
import com.larus.platform.model.camera.CameraSettings;
import com.larus.platform.model.camera.MainCameraFocusFrame;
import com.larus.platform.model.chat.AttachmentEditConfig;
import com.larus.platform.model.chat.ChatAwemeFeedConfig;
import com.larus.platform.model.chat.MessageModifyStyle;
import com.larus.platform.model.chat.ObricWindowMessageBubbleConfig;
import com.larus.platform.model.chat.c0;
import com.larus.platform.model.chat.d0;
import com.larus.platform.model.chat.i0;
import com.larus.platform.model.chat.j0;
import com.larus.platform.model.chat.o;
import com.larus.platform.model.chat.s;
import com.larus.platform.model.chat.w0;
import com.larus.platform.model.chat.x;
import com.larus.platform.model.chat.y;
import com.larus.platform.model.downgrade.BlockRequestDowngradeConfig;
import com.larus.platform.model.downgrade.DelayRequestDowngradeConfig;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.model.downgrade.MockRequestDowngradeConfig;
import com.larus.platform.model.downgrade.ToastRequestDowngradeConfig;
import com.larus.platform.model.mainbot.ECommerceProductCardPreloadConfig;
import com.larus.platform.model.mainbot.ECommerceSettingsConfig;
import com.larus.platform.model.office.LarkMinutesRecordingConfig;
import com.larus.platform.model.office.OfficeRecordingAIInterpreterConfig;
import com.larus.platform.model.office.RecordingPersonalNotesConfig;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.n0;
import com.larus.search.api.IBrowserService;
import com.larus.settings.btm.IBtmSettings;
import com.larus.settings.btm.IEcomBcmSettings;
import com.larus.settings.ivy.IHybridSettings;
import com.larus.settings.ivy.e;
import com.larus.settings.opt.LynxVerifyConfig;
import com.larus.settings.provider.LLMDisclaimerPageUrlConfig;
import com.larus.settings.provider.SendEntityConfig;
import com.larus.settings.provider.actionbar.ActionBarConnectorConfig;
import com.larus.settings.provider.actionbar.ActionbarEntryConfig;
import com.larus.settings.provider.chat.AIFloatChatConfig;
import com.larus.settings.provider.chat.ActionConfig;
import com.larus.settings.provider.chat.InputLeftIconConfig;
import com.larus.settings.provider.chat.InstructionEntranceShowConfig;
import com.larus.settings.provider.chat.QuoteReplyConfig;
import com.larus.settings.provider.diary.DoraDiaryConfig;
import com.larus.settings.provider.health.HealthFirstPartyApplicationConfig;
import com.larus.settings.provider.im.FlowIMApmEventConfig;
import com.larus.settings.provider.im.ImageUploadOptConfig;
import com.larus.settings.provider.music.MusicSaveConfig;
import com.larus.settings.value.a0;
import com.larus.settings.value.a10;
import com.larus.settings.value.a3;
import com.larus.settings.value.a4;
import com.larus.settings.value.a6;
import com.larus.settings.value.a7;
import com.larus.settings.value.a9;
import com.larus.settings.value.aa;
import com.larus.settings.value.ab;
import com.larus.settings.value.ac;
import com.larus.settings.value.ae;
import com.larus.settings.value.af;
import com.larus.settings.value.ag;
import com.larus.settings.value.ah;
import com.larus.settings.value.ak;
import com.larus.settings.value.am;
import com.larus.settings.value.an;
import com.larus.settings.value.ap;
import com.larus.settings.value.aq;
import com.larus.settings.value.at;
import com.larus.settings.value.av;
import com.larus.settings.value.aw;
import com.larus.settings.value.ax;
import com.larus.settings.value.ay;
import com.larus.settings.value.b00;
import com.larus.settings.value.b10;
import com.larus.settings.value.b3;
import com.larus.settings.value.b4;
import com.larus.settings.value.b6;
import com.larus.settings.value.b8;
import com.larus.settings.value.b9;
import com.larus.settings.value.ba;
import com.larus.settings.value.bb;
import com.larus.settings.value.bc;
import com.larus.settings.value.bd;
import com.larus.settings.value.be;
import com.larus.settings.value.bf;
import com.larus.settings.value.bg;
import com.larus.settings.value.bh;
import com.larus.settings.value.bi;
import com.larus.settings.value.bk;
import com.larus.settings.value.bl;
import com.larus.settings.value.bm;
import com.larus.settings.value.bn;
import com.larus.settings.value.bo;
import com.larus.settings.value.bp;
import com.larus.settings.value.br;
import com.larus.settings.value.bu;
import com.larus.settings.value.bv;
import com.larus.settings.value.bw;
import com.larus.settings.value.bx;
import com.larus.settings.value.bz;
import com.larus.settings.value.c1;
import com.larus.settings.value.c2;
import com.larus.settings.value.c3;
import com.larus.settings.value.c5;
import com.larus.settings.value.c6;
import com.larus.settings.value.c8;
import com.larus.settings.value.c9;
import com.larus.settings.value.cb;
import com.larus.settings.value.cc;
import com.larus.settings.value.cd;
import com.larus.settings.value.ce;
import com.larus.settings.value.cf;
import com.larus.settings.value.cg;
import com.larus.settings.value.ch;
import com.larus.settings.value.ci;
import com.larus.settings.value.cj;
import com.larus.settings.value.ck;
import com.larus.settings.value.cl;
import com.larus.settings.value.cn;
import com.larus.settings.value.co;
import com.larus.settings.value.cp;
import com.larus.settings.value.cq;
import com.larus.settings.value.cr;
import com.larus.settings.value.ct;
import com.larus.settings.value.cu;
import com.larus.settings.value.cw;
import com.larus.settings.value.cx;
import com.larus.settings.value.cz;
import com.larus.settings.value.d00;
import com.larus.settings.value.d10;
import com.larus.settings.value.d3;
import com.larus.settings.value.d4;
import com.larus.settings.value.d6;
import com.larus.settings.value.d7;
import com.larus.settings.value.d9;
import com.larus.settings.value.da;
import com.larus.settings.value.dc;
import com.larus.settings.value.dd;
import com.larus.settings.value.de;
import com.larus.settings.value.df;
import com.larus.settings.value.dh;
import com.larus.settings.value.di;
import com.larus.settings.value.dl;
import com.larus.settings.value.dm;
import com.larus.settings.value.dn;
import com.larus.settings.value.dp;
import com.larus.settings.value.dq;
import com.larus.settings.value.dr;
import com.larus.settings.value.ds;
import com.larus.settings.value.dt;
import com.larus.settings.value.du;
import com.larus.settings.value.dv;
import com.larus.settings.value.dw;
import com.larus.settings.value.dy;
import com.larus.settings.value.dz;
import com.larus.settings.value.e00;
import com.larus.settings.value.e10;
import com.larus.settings.value.e3;
import com.larus.settings.value.e4;
import com.larus.settings.value.e5;
import com.larus.settings.value.e7;
import com.larus.settings.value.e8;
import com.larus.settings.value.ea;
import com.larus.settings.value.eb;
import com.larus.settings.value.ec;
import com.larus.settings.value.ed;
import com.larus.settings.value.ee;
import com.larus.settings.value.eg;
import com.larus.settings.value.eh;
import com.larus.settings.value.ej;
import com.larus.settings.value.ek;
import com.larus.settings.value.el;
import com.larus.settings.value.en;
import com.larus.settings.value.eo;
import com.larus.settings.value.er;
import com.larus.settings.value.es;
import com.larus.settings.value.et;
import com.larus.settings.value.eu;
import com.larus.settings.value.ev;
import com.larus.settings.value.ex;
import com.larus.settings.value.f;
import com.larus.settings.value.f00;
import com.larus.settings.value.f5;
import com.larus.settings.value.f6;
import com.larus.settings.value.f7;
import com.larus.settings.value.f8;
import com.larus.settings.value.f9;
import com.larus.settings.value.fa;
import com.larus.settings.value.fb;
import com.larus.settings.value.fc;
import com.larus.settings.value.fd;
import com.larus.settings.value.fe;
import com.larus.settings.value.fg;
import com.larus.settings.value.fh;
import com.larus.settings.value.fi;
import com.larus.settings.value.fl;
import com.larus.settings.value.fm;
import com.larus.settings.value.fn;
import com.larus.settings.value.fo;
import com.larus.settings.value.fp;
import com.larus.settings.value.fq;
import com.larus.settings.value.ft;
import com.larus.settings.value.fu;
import com.larus.settings.value.fw;
import com.larus.settings.value.fx;
import com.larus.settings.value.fy;
import com.larus.settings.value.g00;
import com.larus.settings.value.g1;
import com.larus.settings.value.g2;
import com.larus.settings.value.g3;
import com.larus.settings.value.g6;
import com.larus.settings.value.g7;
import com.larus.settings.value.ga;
import com.larus.settings.value.gb;
import com.larus.settings.value.gc;
import com.larus.settings.value.gd;
import com.larus.settings.value.gh;
import com.larus.settings.value.gi;
import com.larus.settings.value.gj;
import com.larus.settings.value.gk;
import com.larus.settings.value.gl;
import com.larus.settings.value.gm;
import com.larus.settings.value.go;
import com.larus.settings.value.gp;
import com.larus.settings.value.gq;
import com.larus.settings.value.gr;
import com.larus.settings.value.gs;
import com.larus.settings.value.gu;
import com.larus.settings.value.gv;
import com.larus.settings.value.gw;
import com.larus.settings.value.gx;
import com.larus.settings.value.gy;
import com.larus.settings.value.h6;
import com.larus.settings.value.h9;
import com.larus.settings.value.ha;
import com.larus.settings.value.hb;
import com.larus.settings.value.hc;
import com.larus.settings.value.hd;
import com.larus.settings.value.he;
import com.larus.settings.value.hf;
import com.larus.settings.value.hh;
import com.larus.settings.value.hi;
import com.larus.settings.value.hj;
import com.larus.settings.value.hk;
import com.larus.settings.value.hl;
import com.larus.settings.value.hm;
import com.larus.settings.value.hn;
import com.larus.settings.value.ho;
import com.larus.settings.value.hp;
import com.larus.settings.value.hq;
import com.larus.settings.value.hr;
import com.larus.settings.value.hs;
import com.larus.settings.value.hu;
import com.larus.settings.value.hv;
import com.larus.settings.value.hx;
import com.larus.settings.value.hz;
import com.larus.settings.value.i00;
import com.larus.settings.value.i1;
import com.larus.settings.value.i5;
import com.larus.settings.value.i6;
import com.larus.settings.value.i7;
import com.larus.settings.value.i8;
import com.larus.settings.value.i9;
import com.larus.settings.value.ib;
import com.larus.settings.value.id;
import com.larus.settings.value.ie;
import com.larus.settings.value.if;
import com.larus.settings.value.ig;
import com.larus.settings.value.ii;
import com.larus.settings.value.ik;
import com.larus.settings.value.il;
import com.larus.settings.value.im;
import com.larus.settings.value.io;
import com.larus.settings.value.ip;
import com.larus.settings.value.iq;
import com.larus.settings.value.ir;
import com.larus.settings.value.iw;
import com.larus.settings.value.ix;
import com.larus.settings.value.iy;
import com.larus.settings.value.iz;
import com.larus.settings.value.j00;
import com.larus.settings.value.j5;
import com.larus.settings.value.j6;
import com.larus.settings.value.j7;
import com.larus.settings.value.j8;
import com.larus.settings.value.j9;
import com.larus.settings.value.ja;
import com.larus.settings.value.jb;
import com.larus.settings.value.jc;
import com.larus.settings.value.jd;
import com.larus.settings.value.jf;
import com.larus.settings.value.jg;
import com.larus.settings.value.ji;
import com.larus.settings.value.jj;
import com.larus.settings.value.jk;
import com.larus.settings.value.jl;
import com.larus.settings.value.jm;
import com.larus.settings.value.jo;
import com.larus.settings.value.jp;
import com.larus.settings.value.jq;
import com.larus.settings.value.jt;
import com.larus.settings.value.ju;
import com.larus.settings.value.jw;
import com.larus.settings.value.jx;
import com.larus.settings.value.jy;
import com.larus.settings.value.jz;
import com.larus.settings.value.k0;
import com.larus.settings.value.k1;
import com.larus.settings.value.k4;
import com.larus.settings.value.k5;
import com.larus.settings.value.k7;
import com.larus.settings.value.k8;
import com.larus.settings.value.k9;
import com.larus.settings.value.ka;
import com.larus.settings.value.kb;
import com.larus.settings.value.kc;
import com.larus.settings.value.ke;
import com.larus.settings.value.ki;
import com.larus.settings.value.kj;
import com.larus.settings.value.kk;
import com.larus.settings.value.kl;
import com.larus.settings.value.km;
import com.larus.settings.value.kn;
import com.larus.settings.value.ko;
import com.larus.settings.value.kp;
import com.larus.settings.value.kq;
import com.larus.settings.value.kr;
import com.larus.settings.value.kt;
import com.larus.settings.value.ku;
import com.larus.settings.value.kv;
import com.larus.settings.value.kx;
import com.larus.settings.value.ky;
import com.larus.settings.value.kz;
import com.larus.settings.value.l3;
import com.larus.settings.value.l5;
import com.larus.settings.value.l6;
import com.larus.settings.value.l8;
import com.larus.settings.value.la;
import com.larus.settings.value.lb;
import com.larus.settings.value.ld;
import com.larus.settings.value.le;
import com.larus.settings.value.lf;
import com.larus.settings.value.li;
import com.larus.settings.value.lj;
import com.larus.settings.value.lk;
import com.larus.settings.value.ll;
import com.larus.settings.value.ln;
import com.larus.settings.value.lq;
import com.larus.settings.value.lr;
import com.larus.settings.value.ls;
import com.larus.settings.value.lt;
import com.larus.settings.value.lu;
import com.larus.settings.value.lv;
import com.larus.settings.value.lx;
import com.larus.settings.value.lz;
import com.larus.settings.value.m1;
import com.larus.settings.value.m2;
import com.larus.settings.value.m4;
import com.larus.settings.value.m5;
import com.larus.settings.value.m6;
import com.larus.settings.value.m7;
import com.larus.settings.value.m9;
import com.larus.settings.value.ma;
import com.larus.settings.value.mb;
import com.larus.settings.value.mf;
import com.larus.settings.value.mh;
import com.larus.settings.value.mi;
import com.larus.settings.value.mj;
import com.larus.settings.value.mk;
import com.larus.settings.value.mo;
import com.larus.settings.value.mp;
import com.larus.settings.value.mq;
import com.larus.settings.value.mr;
import com.larus.settings.value.ms;
import com.larus.settings.value.mw;
import com.larus.settings.value.my;
import com.larus.settings.value.n00;
import com.larus.settings.value.n1;
import com.larus.settings.value.n5;
import com.larus.settings.value.n6;
import com.larus.settings.value.n7;
import com.larus.settings.value.n9;
import com.larus.settings.value.na;
import com.larus.settings.value.nb;
import com.larus.settings.value.nc;
import com.larus.settings.value.ng;
import com.larus.settings.value.nh;
import com.larus.settings.value.ni;
import com.larus.settings.value.nl;
import com.larus.settings.value.nm;
import com.larus.settings.value.nn;
import com.larus.settings.value.no;
import com.larus.settings.value.np;
import com.larus.settings.value.ns;
import com.larus.settings.value.nt;
import com.larus.settings.value.nu;
import com.larus.settings.value.nw;
import com.larus.settings.value.ny;
import com.larus.settings.value.o4;
import com.larus.settings.value.o6;
import com.larus.settings.value.o8;
import com.larus.settings.value.oa;
import com.larus.settings.value.oc;
import com.larus.settings.value.od;
import com.larus.settings.value.of;
import com.larus.settings.value.og;
import com.larus.settings.value.oi;
import com.larus.settings.value.oj;
import com.larus.settings.value.ok;
import com.larus.settings.value.ol;
import com.larus.settings.value.oo;
import com.larus.settings.value.oq;
import com.larus.settings.value.or;
import com.larus.settings.value.os;
import com.larus.settings.value.ot;
import com.larus.settings.value.ou;
import com.larus.settings.value.ov;
import com.larus.settings.value.oz;
import com.larus.settings.value.p0;
import com.larus.settings.value.p1;
import com.larus.settings.value.p2;
import com.larus.settings.value.p3;
import com.larus.settings.value.p4;
import com.larus.settings.value.p5;
import com.larus.settings.value.p6;
import com.larus.settings.value.p9;
import com.larus.settings.value.pa;
import com.larus.settings.value.pb;
import com.larus.settings.value.pc;
import com.larus.settings.value.pd;
import com.larus.settings.value.pf;
import com.larus.settings.value.pg;
import com.larus.settings.value.pi;
import com.larus.settings.value.pj;
import com.larus.settings.value.pk;
import com.larus.settings.value.pm;
import com.larus.settings.value.pn;
import com.larus.settings.value.po;
import com.larus.settings.value.pp;
import com.larus.settings.value.pr;
import com.larus.settings.value.ps;
import com.larus.settings.value.pt;
import com.larus.settings.value.pu;
import com.larus.settings.value.pv;
import com.larus.settings.value.px;
import com.larus.settings.value.py;
import com.larus.settings.value.q0;
import com.larus.settings.value.q00;
import com.larus.settings.value.q2;
import com.larus.settings.value.q3;
import com.larus.settings.value.q5;
import com.larus.settings.value.q7;
import com.larus.settings.value.q9;
import com.larus.settings.value.qa;
import com.larus.settings.value.qc;
import com.larus.settings.value.qd;
import com.larus.settings.value.qe;
import com.larus.settings.value.qf;
import com.larus.settings.value.qg;
import com.larus.settings.value.qh;
import com.larus.settings.value.qi;
import com.larus.settings.value.qj;
import com.larus.settings.value.qk;
import com.larus.settings.value.qm;
import com.larus.settings.value.qn;
import com.larus.settings.value.qo;
import com.larus.settings.value.qr;
import com.larus.settings.value.qs;
import com.larus.settings.value.qt;
import com.larus.settings.value.qv;
import com.larus.settings.value.qw;
import com.larus.settings.value.qx;
import com.larus.settings.value.qz;
import com.larus.settings.value.r00;
import com.larus.settings.value.r3;
import com.larus.settings.value.r4;
import com.larus.settings.value.r5;
import com.larus.settings.value.r6;
import com.larus.settings.value.r9;
import com.larus.settings.value.ra;
import com.larus.settings.value.rb;
import com.larus.settings.value.rc;
import com.larus.settings.value.rg;
import com.larus.settings.value.ri;
import com.larus.settings.value.rj;
import com.larus.settings.value.rk;
import com.larus.settings.value.rl;
import com.larus.settings.value.rm;
import com.larus.settings.value.rn;
import com.larus.settings.value.rp;
import com.larus.settings.value.rq;
import com.larus.settings.value.rr;
import com.larus.settings.value.rs;
import com.larus.settings.value.ru;
import com.larus.settings.value.rv;
import com.larus.settings.value.rw;
import com.larus.settings.value.rx;
import com.larus.settings.value.rz;
import com.larus.settings.value.s0;
import com.larus.settings.value.s00;
import com.larus.settings.value.s3;
import com.larus.settings.value.s5;
import com.larus.settings.value.s6;
import com.larus.settings.value.s7;
import com.larus.settings.value.s8;
import com.larus.settings.value.s9;
import com.larus.settings.value.sa;
import com.larus.settings.value.sc;
import com.larus.settings.value.sf;
import com.larus.settings.value.sg;
import com.larus.settings.value.sh;
import com.larus.settings.value.si;
import com.larus.settings.value.sk;
import com.larus.settings.value.sl;
import com.larus.settings.value.sm;
import com.larus.settings.value.so;
import com.larus.settings.value.sp;
import com.larus.settings.value.sq;
import com.larus.settings.value.sr;
import com.larus.settings.value.ss;
import com.larus.settings.value.sx;
import com.larus.settings.value.sy;
import com.larus.settings.value.sz;
import com.larus.settings.value.t0;
import com.larus.settings.value.t2;
import com.larus.settings.value.t3;
import com.larus.settings.value.t4;
import com.larus.settings.value.t5;
import com.larus.settings.value.t6;
import com.larus.settings.value.t7;
import com.larus.settings.value.t8;
import com.larus.settings.value.t9;
import com.larus.settings.value.ta;
import com.larus.settings.value.tb;
import com.larus.settings.value.tc;
import com.larus.settings.value.td;
import com.larus.settings.value.tf;
import com.larus.settings.value.tg;
import com.larus.settings.value.th;
import com.larus.settings.value.ti;
import com.larus.settings.value.tk;
import com.larus.settings.value.tl;
import com.larus.settings.value.tm;
import com.larus.settings.value.tn;
import com.larus.settings.value.to;
import com.larus.settings.value.tp;
import com.larus.settings.value.tq;
import com.larus.settings.value.tr;
import com.larus.settings.value.tu;
import com.larus.settings.value.tv;
import com.larus.settings.value.tw;
import com.larus.settings.value.tx;
import com.larus.settings.value.tz;
import com.larus.settings.value.u00;
import com.larus.settings.value.u2;
import com.larus.settings.value.u3;
import com.larus.settings.value.u4;
import com.larus.settings.value.u6;
import com.larus.settings.value.u8;
import com.larus.settings.value.u9;
import com.larus.settings.value.ub;
import com.larus.settings.value.uc;
import com.larus.settings.value.ud;
import com.larus.settings.value.ue;
import com.larus.settings.value.uf;
import com.larus.settings.value.ug;
import com.larus.settings.value.uh;
import com.larus.settings.value.ui;
import com.larus.settings.value.uj;
import com.larus.settings.value.um;
import com.larus.settings.value.un;
import com.larus.settings.value.uo;
import com.larus.settings.value.uq;
import com.larus.settings.value.us;
import com.larus.settings.value.ut;
import com.larus.settings.value.uv;
import com.larus.settings.value.ux;
import com.larus.settings.value.uy;
import com.larus.settings.value.uz;
import com.larus.settings.value.v0;
import com.larus.settings.value.v00;
import com.larus.settings.value.v1;
import com.larus.settings.value.v4;
import com.larus.settings.value.v5;
import com.larus.settings.value.v6;
import com.larus.settings.value.v8;
import com.larus.settings.value.v9;
import com.larus.settings.value.va;
import com.larus.settings.value.vc;
import com.larus.settings.value.vd;
import com.larus.settings.value.vf;
import com.larus.settings.value.vg;
import com.larus.settings.value.vh;
import com.larus.settings.value.vi;
import com.larus.settings.value.vj;
import com.larus.settings.value.vk;
import com.larus.settings.value.vl;
import com.larus.settings.value.vm;
import com.larus.settings.value.vn;
import com.larus.settings.value.vo;
import com.larus.settings.value.vp;
import com.larus.settings.value.vq;
import com.larus.settings.value.vr;
import com.larus.settings.value.vt;
import com.larus.settings.value.vw;
import com.larus.settings.value.w1;
import com.larus.settings.value.w2;
import com.larus.settings.value.w3;
import com.larus.settings.value.w4;
import com.larus.settings.value.w5;
import com.larus.settings.value.w6;
import com.larus.settings.value.w7;
import com.larus.settings.value.w8;
import com.larus.settings.value.wa;
import com.larus.settings.value.wb;
import com.larus.settings.value.wc;
import com.larus.settings.value.wd;
import com.larus.settings.value.we;
import com.larus.settings.value.wf;
import com.larus.settings.value.wg;
import com.larus.settings.value.wh;
import com.larus.settings.value.wj;
import com.larus.settings.value.wk;
import com.larus.settings.value.wl;
import com.larus.settings.value.wm;
import com.larus.settings.value.wp;
import com.larus.settings.value.wq;
import com.larus.settings.value.wr;
import com.larus.settings.value.wt;
import com.larus.settings.value.wu;
import com.larus.settings.value.wv;
import com.larus.settings.value.wx;
import com.larus.settings.value.wy;
import com.larus.settings.value.x00;
import com.larus.settings.value.x1;
import com.larus.settings.value.x6;
import com.larus.settings.value.x7;
import com.larus.settings.value.x8;
import com.larus.settings.value.x9;
import com.larus.settings.value.xa;
import com.larus.settings.value.xb;
import com.larus.settings.value.xc;
import com.larus.settings.value.xd;
import com.larus.settings.value.xe;
import com.larus.settings.value.xf;
import com.larus.settings.value.xg;
import com.larus.settings.value.xh;
import com.larus.settings.value.xi;
import com.larus.settings.value.xj;
import com.larus.settings.value.xl;
import com.larus.settings.value.xm;
import com.larus.settings.value.xn;
import com.larus.settings.value.xp;
import com.larus.settings.value.xr;
import com.larus.settings.value.xs;
import com.larus.settings.value.xt;
import com.larus.settings.value.xv;
import com.larus.settings.value.xw;
import com.larus.settings.value.y0;
import com.larus.settings.value.y00;
import com.larus.settings.value.y1;
import com.larus.settings.value.y2;
import com.larus.settings.value.y4;
import com.larus.settings.value.y5;
import com.larus.settings.value.y8;
import com.larus.settings.value.y9;
import com.larus.settings.value.ya;
import com.larus.settings.value.yb;
import com.larus.settings.value.yc;
import com.larus.settings.value.ye;
import com.larus.settings.value.yf;
import com.larus.settings.value.yg;
import com.larus.settings.value.yi;
import com.larus.settings.value.yk;
import com.larus.settings.value.yl;
import com.larus.settings.value.yn;
import com.larus.settings.value.yo;
import com.larus.settings.value.yq;
import com.larus.settings.value.yr;
import com.larus.settings.value.ys;
import com.larus.settings.value.yt;
import com.larus.settings.value.yu;
import com.larus.settings.value.yv;
import com.larus.settings.value.yw;
import com.larus.settings.value.yx;
import com.larus.settings.value.yy;
import com.larus.settings.value.yz;
import com.larus.settings.value.z;
import com.larus.settings.value.z1;
import com.larus.settings.value.z2;
import com.larus.settings.value.z3;
import com.larus.settings.value.z5;
import com.larus.settings.value.z6;
import com.larus.settings.value.z7;
import com.larus.settings.value.z8;
import com.larus.settings.value.z9;
import com.larus.settings.value.za;
import com.larus.settings.value.zb;
import com.larus.settings.value.zc;
import com.larus.settings.value.zd;
import com.larus.settings.value.ze;
import com.larus.settings.value.zf;
import com.larus.settings.value.zg;
import com.larus.settings.value.zh;
import com.larus.settings.value.zi;
import com.larus.settings.value.zj;
import com.larus.settings.value.zm;
import com.larus.settings.value.zn;
import com.larus.settings.value.zp;
import com.larus.settings.value.zq;
import com.larus.settings.value.zs;
import com.larus.settings.value.zt;
import com.larus.settings.value.zu;
import com.larus.settings.value.zx;
import com.larus.settings.value.zy;
import com.larus.settings.value.zz;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import du9.h1;
import du9.h2;
import du9.j1;
import du9.o0;
import du9.r0;
import du9.r2;
import du9.s2;
import du9.x2;
import ft9.k;
import gv9.a;
import hq9.a2;
import hq9.b2;
import hq9.d1;
import hq9.d2;
import hq9.d5;
import hq9.e1;
import hq9.f0;
import hq9.f1;
import hq9.f3;
import hq9.f4;
import hq9.g0;
import hq9.g5;
import hq9.h0;
import hq9.h3;
import hq9.h5;
import hq9.i3;
import hq9.j3;
import hq9.k2;
import hq9.k3;
import hq9.l1;
import hq9.l4;
import hq9.m;
import hq9.m0;
import hq9.n2;
import hq9.n4;
import hq9.p;
import hq9.q4;
import hq9.r;
import hq9.r1;
import hq9.s1;
import hq9.t;
import hq9.t1;
import hq9.u;
import hq9.u0;
import hq9.v2;
import hq9.v3;
import hq9.w;
import hq9.x3;
import hq9.y3;
import hq9.z0;
import hq9.z4;
import hu9.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.Flow;
import lq9.l;
import mq9.n;
import mv9.b;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import qt9.h4;
import qt9.u1;
import qt9.x4;
import rt9.h;
import vt9.b0;
import vt9.e0;
import vt9.q;
import wv9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class o2 implements m3 {
    public static final o2 a = null;
    public static final CopyOnWriteArraySet<Function0<Unit>> b = null;
    public static final Lazy c = null;
    public static Boolean d;

    public o2() {
    }

    @Override // com.larus.platform.api.m3
    public final boolean A1() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final String B() {
        return "14.92.34-alpha.1-oassistant";
    }

    @Override // com.larus.platform.api.m3
    public final boolean E1() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final String G() {
        return "//flow/debug_activity";
    }

    @Override // com.larus.platform.api.m3
    public final boolean G1() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final boolean I1() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final String O3() {
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m3
    public final String Q1() {
        return "0.1.58";
    }

    @Override // com.larus.platform.api.m3
    public final boolean U1() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final boolean V() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final String X1() {
        return "obric/rls/15.2.0.1";
    }

    @Override // com.larus.platform.api.m3
    public final boolean a1() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final boolean c1() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final String h() {
        return null;
    }

    @Override // com.larus.platform.api.m3
    public final boolean m() {
        return true;
    }

    @Override // com.larus.platform.api.m3
    public final void m0() {
    }

    @Override // com.larus.platform.api.m3
    public final String n0() {
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.m3
    public final int p0() {
        return 887485629;
    }

    @Override // com.larus.platform.api.m3
    public final boolean q2() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final String r2() {
        return "15.2.41-flow";
    }

    @Override // com.larus.platform.api.m3
    public final boolean s0() {
        return true;
    }

    @Override // com.larus.platform.api.m3
    public final String t1() {
        return "fc4b8ba9c915";
    }

    @Override // com.larus.platform.api.m3
    public final boolean u() {
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final String u2() {
        return "not_turned_on";
    }

    @Override // com.larus.platform.api.m3
    public final boolean u3() {
        return true;
    }

    @Override // com.larus.platform.api.m3
    public final void w3() {
    }

    @Override // com.larus.platform.api.m3
    public final String z0() {
        return "2026-09-23 22:02:30";
    }

    static {
        a = new o2();
        b = new CopyOnWriteArraySet();
        SettingsManager.registerListener(new i2(), true);
        c = LazyKt.lazy(new j2());
    }

    @Override // com.larus.platform.api.m3
    public final j0 A() {
        e10 r0 = e10.a;
        return (j0) l0.a(new j0(0), new ka());
    }

    @Override // com.larus.platform.api.m3
    public final boolean A0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ft())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final SimultaneousInterpretationClientConfig A2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (SimultaneousInterpretationClientConfig) l0.a(new SimultaneousInterpretationClientConfig(false, false, 3, null), new ug());
    }

    @Override // com.larus.platform.api.m3
    public final boolean A3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new qz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final a2 B0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        LLMDisclaimerPageUrlConfig r2 = (LLMDisclaimerPageUrlConfig) l0.a(new LLMDisclaimerPageUrlConfig(null, null, null, null, null, 31, null), new q3());
        return new a2(r2.getEntrySystemSetting(), r2.getEntrySystemSettingAbout(), r2.getEntryMainBotFooter(), r2.getEntryNormalBotFooter(), r2.getEntryEPBotFooter());
    }

    @Override // com.larus.platform.api.m3
    public final int B1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new kz())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean B3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new nh())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final w0 C() {
        e10 r0 = e10.a;
        return (w0) l0.a(new w0(0), new b4());
    }

    @Override // com.larus.platform.api.m3
    public final boolean C0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ms())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean C1() {
        e10 r0 = e10.a;
        Boolean r1 = e10.z().i();
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final List<String> C2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        List r2 = ((FlowIMApmEventConfig) l0.a(new FlowIMApmEventConfig(null, null, 3, null), new gp())).getBusinessAllowEventList();
        if (r2 == null) goto L7;
        List<String> r3 = CollectionsKt.filterNotNull(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.platform.api.m3
    public final y3 C3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (y3) l0.a(new y3(0), new dm());
    }

    @Override // com.larus.platform.api.m3
    public final int D() {
        e10 r0 = e10.a;
        return e10.v0().getBotType();
    }

    @Override // com.larus.platform.api.m3
    public final boolean D0() {
        e10 r0 = e10.a;
        return Intrinsics.areEqual(e10.z().f(), Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final String D1() {
        e10 r0 = e10.a;
        String r1 = e10.n0().b();
        if (r1 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r1;
    }

    @Override // com.larus.platform.api.m3
    public final boolean D3() {
        e10 r0 = e10.a;
        return e10.n0().e();
    }

    @Override // com.larus.platform.api.m3
    public final c0 E() {
        e10 r0 = e10.a;
        return (c0) l0.a(new c0(0), new qs());
    }

    @Override // com.larus.platform.api.m3
    public final List<String> E0() {
        e10 r0 = e10.a;
        List<String> r1 = e10.G0().getInterceptPaths();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.platform.api.m3
    public final MainCameraFocusFrame E2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (MainCameraFocusFrame) l0.a(new MainCameraFocusFrame(false, false, 3, null), new co());
    }

    @Override // com.larus.platform.api.m3
    public final boolean E3() {
        e10 r0 = e10.a;
        return e10.n0().g();
    }

    @Override // com.larus.platform.api.m3
    public final List<String> F() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        List<String> r2 = null;
        List r3 = ((FlowIMApmEventConfig) l0.a(new FlowIMApmEventConfig(null, null, 3, null), new gp())).getAllowEventList();
        if (r3 == null) goto L5;
        r2 = CollectionsKt.filterNotNull(r3);
    L5:
        List<String> r4 = r2;
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L14;
        return r2;
    L14:
        return CollectionsKt.listOf(new String[]{"flow_im_message_sent_start", "flow_im_message_sent_end", "flow_im_message_receive_first_package", "flow_im_message_receive_content_end", "flow_av_connect_event", "flow_av_session_exit", "flow_av_query_begin", "flow_av_query_receive_first", "flow_av_query_end", "flow_av_reply_first_text", "flow_av_reply_first_tts", "flow_av_reply_end", "flow_av_engine_pool_event", "flow_im_receive_pocket_text_msg", "flow_im_receive_pocket_card_msg", "event_main_cvs_result"});
    L8:
        if (r4.isEmpty() == true) goto L11;
        r5 = false;
        goto L12
    }

    @Override // com.larus.platform.api.m3
    public final List<String> F0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new ah());
    }

    @Override // com.larus.platform.api.m3
    public final String F1() {
        HttpConst.a.getClass();
        return HttpConst.a0;
    }

    @Override // com.larus.platform.api.m3
    public final boolean F2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new i8())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean F3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return Intrinsics.areEqual(((v) l0.a(new v(), new kn())).a(), Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final boolean G0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new le())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean G2() {
        e10 r0 = e10.a;
        return !Intrinsics.areEqual(e10.s0().a(), Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final boolean G3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new sk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean H() {
        e10 r0 = e10.a;
        return e10.J().c();
    }

    @Override // com.larus.platform.api.m3
    public final u H0() {
        e10 r0 = e10.a;
        boolean r1 = false;
        q r2 = (q) l0.a(new q(0), new gb());
        Boolean r3 = r2.c();
        if (r3 == null) goto L5;
        r1 = r3.booleanValue();
    L5:
        String r4 = r2.b();
        String r5 = XmlPullParser.NO_NAMESPACE;
        if (r4 != null) goto L8;
        r4 = XmlPullParser.NO_NAMESPACE;
    L8:
        String r6 = r2.a();
        if (r6 == null) goto L13;
        r5 = r6;
    L13:
        return new u(r1, r4, r5);
    }

    @Override // com.larus.platform.api.m3
    public final boolean H1() {
        e10 r0 = e10.a;
        return Intrinsics.areEqual(e10.z().g(), Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final boolean H2() {
        e10 r0 = e10.a;
        return e10.n0().k();
    }

    @Override // com.larus.platform.api.m3
    public final x H3() {
        e10 r0 = e10.a;
        return (x) l0.a(new x(0), new v4());
    }

    @Override // com.larus.platform.api.m3
    public final int I() {
        e10 r0 = e10.a;
        return ((a) l0.a(new a(0), new lf())).a();
    }

    @Override // com.larus.platform.api.m3
    public final String I0() {
        e10 r0 = e10.a;
        String r1 = e10.n0().c();
        if (r1 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r1;
    }

    @Override // com.larus.platform.api.m3
    public final boolean I2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new kq())).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (FeatureKitDelegate.b.l0().b() == false) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m3
    public final boolean I3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new tn())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean J() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new s7())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean J1() {
        e10 r0 = e10.a;
        return e10.n0().f();
    }

    @Override // com.larus.platform.api.m3
    public final int J2() {
        int r0 = l0.a;
        return ((Number) l0.a(90, new n2())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean J3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new z())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean K() {
        e10 r0 = e10.a;
        return e10.v0().getEnable();
    }

    @Override // com.larus.platform.api.m3
    public final AudioSyncCallConfig K0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AudioSyncCallConfig) l0.a(new AudioSyncCallConfig(false, false, false, 7, null), new us());
    }

    @Override // com.larus.platform.api.m3
    public final g0 K1() {
        e10 r0 = e10.a;
        du9.u r1 = (du9.u) l0.a(new du9.u(null, 31), new a9());
        return new g0(r1.b(), r1.c(), r1.d(), r1.e(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean K2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new xl())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean K3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new zt())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean L() {
        e10 r0 = e10.a;
        return ((x2) l0.a(new x2(0), new x8())).a();
    }

    @Override // com.larus.platform.api.m3
    public final VideoPortraitConfig L0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (VideoPortraitConfig) l0.a(new VideoPortraitConfig(false, false, false, false, 15, null), new c2());
    }

    @Override // com.larus.platform.api.m3
    public final boolean L1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        if (((Number) l0.a(0, new jk())).intValue() != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final boolean L2() {
        e10 r0 = e10.a;
        return e10.n0().n();
    }

    @Override // com.larus.platform.api.m3
    public final float L3() {
        e10 r0 = e10.a;
        return ((e0) e10.c.getValue()).b();
    }

    @Override // com.larus.platform.api.m3
    public final boolean M() {
        e10 r0 = e10.a;
        return e10.u0().d();
    }

    @Override // com.larus.platform.api.m3
    public final i0 M0() {
        e10 r0 = e10.a;
        return (i0) l0.a(new i0(0), new np());
    }

    @Override // com.larus.platform.api.m3
    public final FlowMarkdownSettings M1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (FlowMarkdownSettings) l0.a(new FlowMarkdownSettings(0, 0, false, false, false, null, null, null, null, false, false, false, 4095, null), new e8());
    }

    @Override // com.larus.platform.api.m3
    public final boolean M2() {
        e10 r0 = e10.a;
        if (e10.H().e() == false) goto L5;
    L10:
        return true;
    L5:
        if (e10.H().a() == true) goto L10;
        if (e10.H().b() == true) goto L10;
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final OboeOptConfig M3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        OboeOptConfig r2 = (OboeOptConfig) l0.a(new OboeOptConfig(false, false, 0, 0, false, 31, null), new hd());
        return new OboeOptConfig(r2.getEnableRecord(), r2.getEnablePlay(), r2.getRecordPerFramesPerCallback(), r2.getPlayPerFramesPerCallback(), r2.getEnableLowLatency());
    }

    @Override // com.larus.platform.api.m3
    public final boolean N() {
        e10 r0 = e10.a;
        return e10.u0().c();
    }

    @Override // com.larus.platform.api.m3
    public final boolean N0() {
        e10 r0 = e10.a;
        Boolean r1 = e10.z().c();
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean N1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new rl())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int N2() {
        e10 r0 = e10.a;
        return ((e0) e10.c.getValue()).a();
    }

    @Override // com.larus.platform.api.m3
    public final TtsOpenGuideConfig N3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        TtsOpenGuideConfig r2 = (TtsOpenGuideConfig) l0.a(new TtsOpenGuideConfig(false, false, null, 7, null), new kp());
        boolean r3 = r2.getEnableEarphoneAuto();
        boolean r4 = r2.getEnableOpenTtsGuide();
        GuideConfig r5 = r2.getConfig();
        float r6 = -1.0f;
        if (r5 == null) goto L5;
        float r7 = r5.getGuideX();
    L6:
        GuideConfig r8 = r2.getConfig();
        if (r8 == null) goto L9;
        int r9 = r8.getGuideY();
    L10:
        GuideConfig r10 = r2.getConfig();
        if (r10 == null) goto L13;
        float r11 = r10.getGuideM();
    L14:
        GuideConfig r12 = r2.getConfig();
        if (r12 == null) goto L18;
        r6 = r12.getGuideN();
    L18:
        return new TtsOpenGuideConfig(r3, r4, new GuideConfig(r7, r9, r11, r6));
    L13:
        r11 = -1.0f;
        goto L14
    L9:
        r9 = -1;
        goto L10
    L5:
        r7 = -1.0f;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final w O() {
        e10 r0 = e10.a;
        return (w) l0.a(new w(0), new sm());
    }

    @Override // com.larus.platform.api.m3
    public final m0 O0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        fu9.a r2 = (fu9.a) l0.a(new fu9.a(), new pc());
        return new m0(r2.a(), r2.c(), r2.b(), r2.d());
    }

    @Override // com.larus.platform.api.m3
    public final boolean O1() {
        e10 r0 = e10.a;
        Boolean r1 = e10.z().m();
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int O2() {
        e10 r0 = e10.a;
        return e10.n0().p();
    }

    @Override // com.larus.platform.api.m3
    public final RealtimeCallSceneModeHelloConfig P0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (RealtimeCallSceneModeHelloConfig) l0.a(new RealtimeCallSceneModeHelloConfig(false, false, 3, null), new fo());
    }

    @Override // com.larus.platform.api.m3
    public final int P2() {
        e10 r0 = e10.a;
        return e10.J0().c();
    }

    @Override // com.larus.platform.api.m3
    public final int P3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((b) l0.a(new b(), new gi())).a();
    }

    @Override // com.larus.platform.api.m3
    public final Flow<Unit> Q() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        DoraServiceImpl$otaNewVersionChangedFlow$.inlined.map.1 r1 = r0.U0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return kotlinx.coroutines.flow.d.a;
    }

    @Override // com.larus.platform.api.m3
    public final List<String> Q0() {
        e10 r0 = e10.a;
        return e10.y().c();
    }

    @Override // com.larus.platform.api.m3
    public final List<String> Q2() {
        return CollectionsKt.listOf(new String[]{"com.larus.live.impl.ttlivesdk.OpenLiveDummyActivity", "com.larus.search.impl.WebActivity", "com.bytedance.locallife.hybrid.page.LifeLynxActivity"});
    }

    @Override // com.larus.platform.api.m3
    public final boolean Q3() {
        e10 r0 = e10.a;
        return ((hu9.x) l0.a(new hu9.x(0), new s0())).b();
    }

    @Override // com.larus.platform.api.m3
    public final boolean R() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new n5())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean R0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.a();
        return ((AIFloatChatConfig) l0.a(new AIFloatChatConfig(false, false, 3, null), new r5())).getEcommerceUserPromptHoverEnabled();
    }

    @Override // com.larus.platform.api.m3
    public final RealtimeCallBtnPositionConfig R1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (RealtimeCallBtnPositionConfig) l0.a(new RealtimeCallBtnPositionConfig(), new v6());
    }

    @Override // com.larus.platform.api.m3
    public final boolean R2() {
        e10 r0 = e10.a;
        return e10.J().a();
    }

    @Override // com.larus.platform.api.m3
    public final boolean R3() {
        e10 r0 = e10.a;
        return Intrinsics.areEqual(e10.z().n(), Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final boolean S() {
        e10 r0 = e10.a;
        Boolean r1 = e10.z().p();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean S0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.u())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final SpeakStyleConfig S1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        SpeakStyleConfig r2 = (SpeakStyleConfig) l0.a(new SpeakStyleConfig(false, false, 3, null), new x6());
        return new SpeakStyleConfig(r2.getEnableNewStyle(), r2.getCancelIsRed());
    }

    @Override // com.larus.platform.api.m3
    public final int S2() {
        ArrayList r0 = e.a;
        return ((IHybridSettings) SettingsManager.obtain(IHybridSettings.class)).hybridExperimentConfig().a();
    }

    @Override // com.larus.platform.api.m3
    public final g5 S3() {
        e10 r0 = e10.a;
        x4 r1 = (x4) l0.a(new x4(0), new bk());
        return new g5(r1.a(), r1.b());
    }

    @Override // com.larus.platform.api.m3
    public final boolean T() {
        e10 r0 = e10.a;
        return ((x2) l0.a(new x2(0), new x8())).b();
    }

    @Override // com.larus.platform.api.m3
    public final List<String> T0() {
        e10 r0 = e10.a;
        List r1 = e10.T().a();
        if (r1 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.filterNotNull(r1);
    }

    @Override // com.larus.platform.api.m3
    public final boolean T1() {
        e10 r0 = e10.a;
        Boolean r1 = e10.z().e();
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int T2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1, new cr())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.b T3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new ut9.a();
        return (hq9.b) l0.a(new hq9.b(0), new ub());
    }

    @Override // com.larus.platform.api.m3
    public final y U() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        InputLeftIconConfig r2 = (InputLeftIconConfig) l0.a(new InputLeftIconConfig(false, false, 3, null), new wm());
        return new y(r2.isMainBotColorIconEnable(), r2.isOtherBotColorIconEnable());
    }

    @Override // com.larus.platform.api.m3
    public final p U0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (p) l0.a(new p(), new k1());
    }

    @Override // com.larus.platform.api.m3
    public final n U2() {
        e10 r0 = e10.a;
        return (n) l0.a(new n(0), new rp());
    }

    @Override // com.larus.platform.api.m3
    public final RealtimeCallAddEventConfig U3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (RealtimeCallAddEventConfig) l0.a(new RealtimeCallAddEventConfig(null, null, null, 7, null), new oj());
    }

    @Override // com.larus.platform.api.m3
    public final boolean V0() {
        e10 r0 = e10.a;
        return Intrinsics.areEqual(e10.z().d(), Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final boolean V1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new v9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final AudioRetransmitStrategyModel V2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AudioRetransmitStrategyModel) l0.a(new AudioRetransmitStrategyModel(null, 1, null), new il());
    }

    @Override // com.larus.platform.api.m3
    public final boolean V3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new z1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final List<String> W() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(new ArrayList(), new cx());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.p W0() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.p) l0.a(new com.larus.platform.model.chat.p(0), new jj());
    }

    @Override // com.larus.platform.api.m3
    public final boolean W1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((MessageActionConfig) l0.a(new MessageActionConfig(false, 1, null), new xt())).getDisableReplyFold();
    }

    @Override // com.larus.platform.api.m3
    public final long W2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(3000L, new sg())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final List<String> W3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        List r2 = ((h1) l0.a(new h1(null), new rg())).a();
        if (r2 == null) goto L7;
        List<String> r3 = CollectionsKt.filterNotNull(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.platform.api.m3
    public final l X() {
        e10 r0 = e10.a;
        l r1 = (l) l0.a(new l(false, false), new com.larus.settings.value.j2());
        return new l(r1.a(), r1.b());
    }

    @Override // com.larus.platform.api.m3
    public final int X0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(160, new w4())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final i3 X2() {
        e10 r0 = e10.a;
        return new i3(((h) l0.a(new h(0), new pf())).a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean X3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new yq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int Y() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(24000, new ek())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final v3 Y0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return new v3(((du9.a2) l0.a(new du9.a2(), new t0())).a());
    }

    @Override // com.larus.platform.api.m3
    public final int Y1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(10, new jf())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean Y2() {
        e10 r0 = e10.a;
        return e10.n0().h();
    }

    @Override // com.larus.platform.api.m3
    public final boolean Y3() {
        e10 r0 = e10.a;
        return !Intrinsics.areEqual(e10.z().l(), Boolean.FALSE);
    }

    @Override // com.larus.platform.api.m3
    public final int Z() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new dz())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final List<String> Z0() {
        e10 r0 = e10.a;
        List r1 = e10.T().c();
        if (r1 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.filterNotNull(r1);
    }

    @Override // com.larus.platform.api.m3
    public final String Z1() {
        String r0 = com.larus.setting.api.u.a;
        return com.larus.setting.api.u.f;
    }

    @Override // com.larus.platform.api.m3
    public final boolean Z2() {
        e10 r0 = e10.a;
        return ((c) l0.a(new c(0), new yy())).a();
    }

    @Override // com.larus.platform.api.m3
    public final String Z3() {
        e10 r0 = e10.a;
        return e10.T().b();
    }

    @Override // com.larus.platform.api.m3
    public final boolean a() {
        e10 r0 = e10.a;
        return e10.n0().m();
    }

    @Override // com.larus.platform.api.m3
    public final boolean a0() {
        e10 r0 = e10.a;
        return Intrinsics.areEqual(e10.s0().c(), Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final boolean a2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new e7())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final s a3() {
        e10 r0 = e10.a;
        return (s) l0.a(new s(0), new uo());
    }

    @Override // com.larus.platform.api.m3
    public final boolean actionBarSecondMenuShowFix() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new f())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean actionBarShowDurationOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new de())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean adjustPageBottomSpaceOnlyAndroid() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new la())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final HashMap<String, Object> aecMicSelectorConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (HashMap) l0.a(new HashMap(), new bb());
    }

    @Override // com.larus.platform.api.m3
    public final AigcMetadataConfig aigcMetadataConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AigcMetadataConfig) l0.a(new AigcMetadataConfig(false, false, 3, null), new kl());
    }

    @Override // com.larus.platform.api.m3
    public final boolean albumSdkEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new cp())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean albumUnifiedAgent() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new tk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean androidPreprocessOptFileSize() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new t6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean applyAudioFocusNew() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new a7())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean applyMmtUnpublish() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new tu())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean asrSessionComponentSplit() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new pm())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final ASRStrengthenConfig asrStrengthenConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        if (AppHost.a.isOversea() == false) goto L5;
        ASRStrengthenConfig.Companion.getClass();
        ASRStrengthenConfig r2 = ASRStrengthenConfig.access$getV0$cp();
    L7:
        return (ASRStrengthenConfig) l0.a(r2, new yn());
    L5:
        ASRStrengthenConfig.Companion.getClass();
        r2 = ASRStrengthenConfig.access$getV1_CN$cp();
        goto L7
    }

    @Override // com.larus.platform.api.m3
    public final boolean asrUseGainTransientFocusType() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new uz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final AttachmentEditConfig attachmentEditConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AttachmentEditConfig) l0.a(new AttachmentEditConfig(null, null, null, null, null, null, false, 127, null), new pg());
    }

    @Override // com.larus.platform.api.m3
    public final boolean audioConnectionPoolRecreateEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.w())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.q audioDebugAutoDumpConfig() {
        e10 r0 = e10.a;
        return (hq9.q) l0.a(new hq9.q(0), new zf());
    }

    @Override // com.larus.platform.api.m3
    public final AudioDebugConfig audioDebugDumpConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AudioDebugConfig) l0.a(new AudioDebugConfig(0, 0, 0, 0, 0, 0, 0, 0, 255, null), new dl());
    }

    @Override // com.larus.platform.api.m3
    public final AudioFeedbackFrequencyConfig audioFeedbackFrequencyConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AudioFeedbackFrequencyConfig) l0.a(new AudioFeedbackFrequencyConfig(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, null), new gr());
    }

    @Override // com.larus.platform.api.m3
    public final AudioFeedbackSwitch audioFeedbackSwitch() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AudioFeedbackSwitch) l0.a(new AudioFeedbackSwitch(false, false, false, 7, null), new yf());
    }

    @Override // com.larus.platform.api.m3
    public final r audioSoundsQualityConfig() {
        e10 r0 = e10.a;
        return (r) l0.a(new r(0), new eu());
    }

    @Override // com.larus.platform.api.m3
    public final boolean audioTtsUseSceneVerify() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new p4())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final AutoReadTtsOptConfig autoReadTtsOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AutoReadTtsOptConfig) l0.a(new AutoReadTtsOptConfig(false, false, 3, null), new n6());
    }

    @Override // com.larus.platform.api.m3
    public final kq9.a b() {
        e10 r0 = e10.a;
        gt9.a r1 = (gt9.a) l0.a(new gt9.a(false, false, false), new k5());
        return new kq9.a(r1.b(), r1.c(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean b0() {
        e10 r0 = e10.a;
        Boolean r1 = e10.z().k();
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final RealtimeCallSceneModeConfig b1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (RealtimeCallSceneModeConfig) l0.a(new RealtimeCallSceneModeConfig(false, 0, false, false, 15, null), new bf());
    }

    @Override // com.larus.platform.api.m3
    public final boolean b2() {
        e10 r0 = e10.a;
        vt9.f r1 = e10.z().o();
        if (r1 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r1.b(), Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final int b3() {
        e10 r0 = e10.a;
        return e10.n0().r();
    }

    @Override // com.larus.platform.api.m3
    public final er9.a b4() {
        e10 r0 = e10.a;
        uu9.a r1 = e10.I();
        uu9.c r2 = r1.o();
        er9.b r3 = null;
        if (r2 == null) goto L5;
        er9.b r4 = new er9.b(r2.a(), r2.c(), r2.b());
    L6:
        uu9.c r5 = r1.m();
        if (r5 == null) goto L10;
        r3 = new er9.b(r5.a(), r5.c(), r5.b());
    L10:
        return new er9.a(r4, r3, r1.n(), r1.h());
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final boolean botCreateEnable() {
        e10 r0 = e10.a;
        if (e10.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (FeatureKitDelegate.b.D0().b() == false) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m3
    public final nq9.d botSettingShareBtnConfig() {
        e10 r0 = e10.a;
        boolean r1 = false;
        Boolean r2 = ((g) l0.a(new g(0), new com.larus.settings.value.e0())).a();
        if (r2 == null) goto L6;
        r1 = r2.booleanValue();
    L6:
        return new nq9.d(r1);
    }

    @Override // com.larus.platform.api.m3
    public final boolean c() {
        e10 r0 = e10.a;
        return e10.n0().q();
    }

    @Override // com.larus.platform.api.m3
    public final v2 c0() {
        k.a.getClass();
        return k.k;
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.g c2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.n();
        return (com.larus.platform.model.chat.g) l0.a(new com.larus.platform.model.chat.g(0), new o6());
    }

    @Override // com.larus.platform.api.m3
    public final boolean c3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new vm())).booleanValue();
    }

    public final lq9.p c4() {
        e10 r0 = e10.a;
        h4 r1 = (h4) l0.a(new h4(0), new fl());
        return new lq9.p(r1.a(), r1.d(), r1.e(), r1.c(), r1.b());
    }

    @Override // com.larus.platform.api.m3
    public final boolean callDisableSwitchAvatar() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new jc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final oq9.e cameraFreeInputConfig() {
        e10 r0 = e10.a;
        bu9.f r1 = (bu9.f) l0.a(new bu9.f(0), new ee());
        return new oq9.e(r1.a(), r1.b());
    }

    @Override // com.larus.platform.api.m3
    public final ir9.b cameraInitOptConfig() {
        e10 r0 = e10.a;
        mt9.a r1 = (mt9.a) l0.a(new mt9.a(0), new gj());
        return new ir9.b(r1.c(), r1.b(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.c0 cameraInputOptimizeConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new i();
        return new hq9.c0(((bu9.h) l0.a(new bu9.h(0), new y2())).a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean canLongActionAddRegenerate() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ov())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean canShowAnswerActionBar() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new u6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int centerActionStyle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new wv())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean chatImmerseEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new r6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.e0 chatInputEditTextOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new ot9.b();
        return (hq9.e0) l0.a(new hq9.e0(0), new ld());
    }

    @Override // com.larus.platform.api.m3
    public final f0 chatInputOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new ot9.c();
        return (f0) l0.a(new f0(0), new w2());
    }

    @Override // com.larus.platform.api.m3
    public final int chatInputType() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1, new xn())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean chatListLoginGuideBannerEnabled() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new gs())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final long chatTopFloatButtonShowTime() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(5000L, new gm())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean clipTableHtmlEnabled() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new hz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final CloseAudioConnectionAppBackgroundConfig closeAudioConnectionAppBackgroundConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (CloseAudioConnectionAppBackgroundConfig) l0.a(new CloseAudioConnectionAppBackgroundConfig(false, null, 3, null), new f5());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.j0 cognitiveConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new ot9.e();
        ot9.d r2 = (ot9.d) l0.a(ot9.e.a(), new ot());
        return new hq9.j0(r2.b(), r2.a(), r2.c());
    }

    @Override // com.larus.platform.api.m3
    public final boolean collectEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new jo())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean configListReorder() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new kb())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean connectionCreateBeforeUseEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ol())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean consumePushSDKSettings() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ax())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.k continueTalkV2Config() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (lq9.k) l0.a(new lq9.k(0), new qx());
    }

    @Override // com.larus.platform.api.m3
    public final int continuousTalkClickAlignment() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new aa())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final int continuousTalkLeftButtonStyle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new p0())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean coroutinesOptV1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new j6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean coroutinesOptV2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new cn())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean createBotAutoFillEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new en())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean createNewConversationNewIcon() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new c1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int creationDetailClickAction() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new com.larus.settings.value.g0())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean creationDetailVideoEngineLeakFix() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ke())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean creationDetailVideoFocusFix() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new uf())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean creationFeedEntranceReverse() {
        e10 r0 = e10.a;
        return e10.d();
    }

    @Override // com.larus.platform.api.m3
    public final boolean creationFeedHolderOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new vp())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean creationFeedThumbRatioLimit43() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new na())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean creationFeedVideoAutoPlay() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new l5())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final kq9.g creationImageReviewOptConfig() {
        e10 r0 = e10.a;
        return (kq9.g) l0.a(new kq9.g(0), new xs());
    }

    @Override // com.larus.platform.api.m3
    public final kq9.h creationImageUploadReuseConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (kq9.h) l0.a(new kq9.h(0), new com.larus.settings.value.v2());
    }

    @Override // com.larus.platform.api.m3
    public final boolean creationInstructionKmpEnabled() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new wp())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final kq9.i creationNoWatermarkConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (kq9.i) l0.a(new kq9.i(0), new qn());
    }

    @Override // com.larus.platform.api.m3
    public final kq9.k creationResourceAccessOptConfig() {
        e10 r0 = e10.a;
        return (kq9.k) l0.a(new kq9.k(0), new ny());
    }

    @Override // com.larus.platform.api.m3
    public final boolean creationSendMessageOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new t2())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final HashMap<String, String> crowdTestFeedbackReason() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (HashMap) l0.a(new HashMap(), new y00());
    }

    @Override // com.larus.platform.api.m3
    public final int d() {
        e10 r0 = e10.a;
        vt9.f r1 = e10.z().o();
        if (r1 == null) goto L7;
        Integer r2 = r1.a();
        if (r2 == null) goto L7;
        return r2.intValue();
    L7:
        return -1;
    }

    @Override // com.larus.platform.api.m3
    public final int d0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1, new fb())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final int d1() {
        e10 r0 = e10.a;
        return e10.F0();
    }

    @Override // com.larus.platform.api.m3
    public final boolean d2() {
        e10 r0 = e10.a;
        Boolean r1 = e10.v().a();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final JSONObject d3() {
        return SettingsManager.obtainSettingsFast(AppHost.a.getApplication()).getAppSettings();
    L4:
        return null;
    }

    public final hr9.g d4() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new zv9.e();
        return (hr9.g) l0.a(zv9.e.a(), new fy());
    }

    @Override // com.larus.platform.api.m3
    public final int deepResearchPodcastLoadingTimeoutInterval() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(10000, new b00())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final int deepResearchPodcastUseIconType() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new py())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final int deepThinkActionBarTipDismissDuration() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(3000, new cw())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final o deepThinkOptimizeConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (o) l0.a(new o(), new di());
    }

    @Override // com.larus.platform.api.m3
    public final boolean delayPromptShowReport() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ti())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableAudioTraceSpan() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new j8())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableCommonSettingsVoiceCreate() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new fx())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableCreationOriImageLoad() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new wj())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableFix1340InputSendProblem() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new jp())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableMoaStartCall() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new pa())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disablePuzzleSizeLimit() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new a0())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableReUploadGeneratedImg() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new rq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableRealtimeCallSubtitleOpenControlForMainBot() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new vo())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableRealtimeCallSubtitleOpenControlForUgcBot() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ha())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableTouristActionBarCreation() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new dt())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean disableVoiceInput() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new lj())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int docDetailPageEditIconStyle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new qo())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean downgradeCreationFeedVideoFix() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new pt())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean e() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        r0.e();
        return false;
    L7:
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final t e0() {
        e10 r0 = e10.a;
        t r1 = e10.z().q();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new t(0);
    }

    @Override // com.larus.platform.api.m3
    public final boolean e2() {
        if (d != null) goto L6;
        d = Boolean.valueOf(getMarkdownOptimizeConfig().n);
    L6:
        return Intrinsics.areEqual(d, Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final lq9.n e3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return new lq9.n(((nu9.g) l0.a(new nu9.g(), new gq())).a());
    }

    public final int e4() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new bu9.s();
        Integer r2 = ((oq9.h) l0.a(bu9.s.a(), new w5())).b();
        if (r2 != null) goto L7;
        return 5;
    L7:
        return r2.intValue();
    }

    @Override // com.larus.platform.api.m3
    public final uq9.b ecActivityThemeConfig() {
        e10 r0 = e10.a;
        return (uq9.b) l0.a(null, new sq());
    }

    @Override // com.larus.platform.api.m3
    public final List<String> ecommerceAuthorizationWhiteList() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new r00());
    }

    @Override // com.larus.platform.api.m3
    public final boolean eduUploadOriginImage() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new y9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAICreationApplet() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new ls())).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (e10.d() == true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAICreationAppletKmpFeed() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new cf())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableASRTimeoutTaskTrace() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new sz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAddAlbumCreationInput() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new zj())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAddLoadingViewToCaijing() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new vg())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAddPartImageOnlyAndroid() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new xj())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAnnieXLiveMethodProviderFirst() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new rw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAnswerActionExposurePriority() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.c0())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAsrFailedBeforeACKTraceAsync() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ay())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAsrInputViewMarginFix() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new qf())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAsrNewAnim() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new h6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAsrWithImageQueryInfo() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new lz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAsyncCallLifecycleDispatch() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.o())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAudioBgSimpleColor() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new bg())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final AudioConnectionPoolConfig enableAudioConnectionPoolConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AudioConnectionPoolConfig) l0.a(new AudioConnectionPoolConfig(false, null, null, 7, null), new yl());
    }

    @Override // com.larus.platform.api.m3
    public final int enableAudioInputWithAttachment() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1, new z9())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAudioNewTheme() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new pk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAudioPlayerFlushWithSilence() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new hh())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAudioPlayerTimeoutCheck() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new aq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAudioRecordSilencedCheck() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new m1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAutoOpenSubtitle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new g2())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAutoPlayAudioZeroVolumeToast() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new jx())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableAutoStartByNoSilentFrame() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new yw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableBackUpToPreviousReadPosition() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new hk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int enableBioInChatTop() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new xp())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableBlockImagePreviewResize() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new z3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableBluetoothDevicesReportEvent() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new s3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableBlurRoundRectDraw() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new yo())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableBootNetOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new xr())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int enableBootNqeOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new px())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final HashMap<String, Integer> enableBootPathOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (HashMap) l0.a(new HashMap(), new wx());
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCamera2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new dd())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCameraEffectOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new gk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCameraFrameSyncDispatch() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new gx())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCameraLumaDetectOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new hx())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableChatInputDeleteOverflowFix() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new if())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableChatInputIconCompat() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ok())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableChatSpeakerBuilder() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new bd())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableChatTimestampNoLeadingZero() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new x1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableChatWithTab() {
        e10 r0 = e10.a;
        return e10.k();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableClientAvatarDetectAlgorithm() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new an())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCollectionForceRefresh() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new mb())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCreationActionbarConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ci())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCreationFileWatermark() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new eh())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCreationMixSkillAlbumMultiSelect() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new fa())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCreationMsgExportFile() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new wr())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCreationResourceAccessPipeline() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new tw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableCreationVideoDownloadOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new mh())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableDataTagOptimize() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new jm())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableDirectJumpCameraCaptureFirst() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new a10())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableDoraLarkRecord() {
        e10 r0 = e10.a;
        return e10.m();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableEduVlmMigration() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new vf())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableEnterKeyBehaviorSetting() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new k0())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableEnterpriseDownloadWatermark() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new m9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableFastAlbumSmallWindowAdapt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.v3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableFilterDeletedBotConversation() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new xm())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableFixCidUidMismatch() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new cq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableForceBindDouyinV2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new xc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableGeneralInternetCodeHeaderIcon() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new yz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableGetBotListAfterSaveVoice() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new hc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableGlobalActivityTheme() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new si())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableHasHumanTag() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new bl())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableImagePreprocessCacheFallback() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ni())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableImageUploadConvertToSrgb() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new qj())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableInterpretAutoStartByFrame() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new zx())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableIvyWebviewDecode() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ps())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableKeepInputLeftIcon() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new mw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableKeepScreenOnDuringTTS() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new yk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableKeepScreenOnGuardLegacyScenes() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new d9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableKeepScreenOnReply() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ii())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableKmpAsr() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ir())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableKmpTts() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new mi())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableKmpTtsCancelTaskIdCheck() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new cl())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableKmpVoiceSetting() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new b3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableLeftActionCameraShow() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new to())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableLocalFaceDetect() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new jl())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableLogoutAll() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new yv())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableLogoutOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new eb())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableLongImageAutoFit() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new rm())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMainBotNewSetting() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new pn())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMarkdownContainerAppletLastBlockInset() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new wy())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMdWidgetsMixedArrangement() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new tr())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMessageHover() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new xg())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMessageListClipBottomToMaxHeight() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new et())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMessageMention() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ma())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMessageMenuTimestamp() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new df())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMessageScrollFreezeAfterFirstInput() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new v0())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMessageSkillDetailPage() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new nm())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMessageUrlPreview() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new k9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMiaodaArtifactCommonWebContainer() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new n00())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMiaodaPrewarm() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new zz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMixSkillReeditHalfScreen() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new vn())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMoaAudioRecordStreamOptimizeInterceptor() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ak())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableModeSwitchTitleIcon() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new jw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMuseumExtensionPack() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new qr())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMusicSaveTtcnpa() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new y1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableMusicVideoSizeDowngradeFix() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new w1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableNewActionShown() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.q())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableNewAddLocalMessageStrategy() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new u8())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableNewSamiEndpoint() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new tq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableNonLotteryShuffle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new rk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableObricIndependentTts() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new pp())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableOfficeDataPrefetch() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new zn())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableOfficeSdkInitOnEnterpriseOnline() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new vt())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableOfficeSdkLifecycleAsyncInit() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new lt())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableOfficeUrlPreview() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new sc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableOfficialWebsite() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ku())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableOptAsrNullableBotId() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new sp())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableOptAsrRetry() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new bz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableOptAsrSamiNotReady() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ru())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enablePocketDataLaunchReq() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.f0())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.k enablePreloadChatPageView() {
        e10 r0 = e10.a;
        return e10.D0();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enablePromptFilter() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new sy())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enablePromptLoading() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new hs())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableQuotaExceededPerformBackAtFront() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ky())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallDowngrade() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new q2())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallEarphoneSwitchToast() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new vk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallGroup() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.g())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallInterpretForceReportMessage() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new gy())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallOptSelfInterrupt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ys())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallSubtitle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new j5())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallSubtitleASR() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new qe())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallSubtitleAutoOpen() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new gl())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallSubtitleOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ds())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallSubtitleRecordOpen() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new mk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallTakePhoto() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new jq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeCallTakePhotoSkipBotCheck() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new fi())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRealtimeMmtCameraOesDirectPush() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new nu())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableReceiveMsgBubbleExpand() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new yi())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRecommendBotAgain() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new vj())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableReferenceMessageWithAttachment() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new hr())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRenameRenewSection() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new vl())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableRuyiLynxViewRecycle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new y8())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableSaveInputStatusToKeva() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new fn())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableScanToPayInApp() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new wq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableScreenShareNewTheme() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new y0())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableShareStreaming() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new cj())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableShowDisclaimer() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new zd())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableSlidesPresentation() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new s6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableStandardLinkNavigation() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new vc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableSubSmallAvatar() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new yt())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableSubscribeTitleEntrance() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new sf())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableSubscriberMainBotNewSkin() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ta())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableSubscriberMultiBotNewSkin() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new fq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableSubscription() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new k7())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableSwDpOffline() {
        if (n0.a.b() == false) goto L7;
        return true;
    L7:
        if (nda.d.a().ra() == false) goto L10;
        return false;
    L10:
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new s5())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableSyncClientInfo() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new i1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTTSZeroVolumeOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new g1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTableCopyExcelStyle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new kk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTopBeautyButton() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new b8())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTopLeftMainBotUnclick() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ga())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTraceCollectOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new tz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTrackerOptimize() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new uq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTtsCache() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new xf())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTtsMarkOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new fw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTtsMediaSession() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new rr())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTtsStateCheckBeforeCancel() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new r9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTtsWhenStreaming() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new d4())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableTypingAsyncOptimize() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new xh())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableUgcBotBlockSwitch() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new x7())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableUseOlympusAccountParam() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new e00())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVeCameraLogOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new nt())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVeCaptureRtcSetting() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new bw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVeCaptureTargetSize() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new zs())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVeInitSerialization() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new mo())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVideoCaptureStartStatusAlignRtc() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ho())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVideoDownloadMdl() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new bh())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVideoPinch() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new m4())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVoiceMixInput() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new od())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVoiceMixInputTwoPass() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new xw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableVoiceSettingTalkback() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.valueOf(!AppHost.a.isOversea()), new n1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableZeroVolumeToastFrequencyControl() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new cz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean enableZlinkCheckClipboardNotOnlyAppStart() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new wk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final ExportFileConfig exportFileConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (ExportFileConfig) l0.a(new ExportFileConfig(false, false, false, false, 0, 31, null), new xe());
    }

    @Override // com.larus.platform.api.m3
    public final boolean f() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.f();
    }

    @Override // com.larus.platform.api.m3
    public final String f0() {
        e10 r0 = e10.a;
        String r1 = e10.n0().a();
        if (r1 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r1;
    }

    @Override // com.larus.platform.api.m3
    public final sq9.o f1() {
        return ICommunityService.a.f1();
    }

    @Override // com.larus.platform.api.m3
    public final int f2() {
        e10 r0 = e10.a;
        return e10.J0().b();
    }

    public final boolean f4() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new or())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean fastAlbumSingleUploadAttachmentSyncEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new u4())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean fastButtonEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new t3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final d1 firstFeedOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new ot9.l();
        ot9.k r2 = (ot9.k) l0.a(ot9.l.a(), new p2());
        return new d1(r2.a(), r2.b(), r2.c());
    }

    @Override // com.larus.platform.api.m3
    public final boolean fixAnrOnAudioPluginStart() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new w3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean fixAudioPlayManagerPlayEnd() {
        e10 r0 = e10.a;
        return e10.p();
    }

    @Override // com.larus.platform.api.m3
    public final boolean fixFrontierConnect() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.l0())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean fixRealtimeCameraPadRotationEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ux())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean fixRealtimeCameraStopPreviewBeforeDestroyEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new dv())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean fixRealtimeTalkbackEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new g7())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean fixTouristRealtimeCallEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new l3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean forceOpenFusionDoc() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new wf())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean g1() {
        e10 r0 = e10.a;
        return e10.h0().a();
    }

    @Override // com.larus.platform.api.m3
    public final boolean g2() {
        e10 r0 = e10.a;
        uu9.a r1 = e10.I();
        if (r1.g() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.i() == false) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m3
    public final boolean g3() {
        e10 r0 = e10.a;
        return e10.G0().getEnableCrossClipboardRead();
    }

    public final String g4() {
        e10 r0 = e10.a;
        return (String) l0.a(XmlPullParser.NO_NAMESPACE, new v1());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.n1 genImageLoadingAnimationConfig() {
        e10 r0 = e10.a;
        r0 r1 = (r0) l0.a(new r0(false, false, 7), new xi());
        return new hq9.n1(r1.c(), r1.b(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.a getAIBeautifyConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        qt9.a r2 = (qt9.a) l0.a(new qt9.a(), new wa());
        Boolean r3 = r2.defaultKeyboardInvoke;
        boolean r4 = false;
        if (r3 == null) goto L5;
        boolean r5 = r3.booleanValue();
    L6:
        Boolean r6 = r2.instructionOnImage;
        if (r6 == null) goto L10;
        r4 = r6.booleanValue();
    L10:
        return new hq9.a(r5, r4);
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final jq9.a getActionBarConnectorConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        ActionBarConnectorConfig r2 = (ActionBarConnectorConfig) l0.a(new ActionBarConnectorConfig(false, null, null, 7, null), new iw());
        String r3 = r2.getAcbAddConnectorSchema();
        String r4 = r2.getAcbConnectorLinkSchema();
        boolean r5 = r2.getAcbConnectorEnable();
        if (r3 != null) goto L5;
        r3 = XmlPullParser.NO_NAMESPACE;
    L5:
        if (r4 != null) goto L8;
        r4 = XmlPullParser.NO_NAMESPACE;
    L8:
        return new jq9.a(r5, r3, r4);
    }

    @Override // com.larus.platform.api.m3
    public final jq9.k getActionBarEntryConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        ActionbarEntryConfig r2 = (ActionbarEntryConfig) l0.a(new ActionbarEntryConfig(false, false, false, false, 0, false, 63, null), new fd());
        return new jq9.k(r2.getAbcEntryExpandEnable(), r2.getAbcEntryReorderEnable(), r2.getAbcEntryRedDotEnable(), r2.getAbcEntryRedDotToText(), r2.getAbcEntryRedDotMaxExposureTimes(), r2.getEnableShowInstructionUpdateDialog());
    }

    @Override // com.larus.platform.api.m3
    public final jq9.c getActionBarGradientConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (jq9.c) l0.a(new jq9.c(0), new ed());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.a getActionBarOptConfig() {
        e10 r0 = e10.a;
        return com.larus.platform.model.chat.a.a(e10.s(), ((Boolean) e10.f.getValue()).booleanValue());
    }

    @Override // com.larus.platform.api.m3
    public final tq9.a getAiDocCellExposeConfig() {
        e10 r0 = e10.a;
        return new tq9.a(((mu9.a) l0.a(new mu9.a(0), new qw())).a());
    }

    @Override // com.larus.platform.api.m3
    public final tq9.b getAiDocConfig() {
        e10 r0 = e10.a;
        return new tq9.b(((mu9.c) l0.a(new mu9.c(0), new hv())).a());
    }

    @Override // com.larus.platform.api.m3
    public final tq9.c getAiDocDdxmlConfig() {
        e10 r0 = e10.a;
        return new tq9.c(((mu9.e) l0.a(new mu9.e(0), new dr())).a());
    }

    @Override // com.larus.platform.api.m3
    public final String getAiDocFEConfig() {
        e10 r0 = e10.a;
        return (String) l0.a(XmlPullParser.NO_NAMESPACE, new kt());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.f getAllowTrainingConfig() {
        e10 r0 = e10.a;
        return (hq9.f) l0.a(new hq9.f(0), new sl());
    }

    @Override // com.larus.platform.api.m3
    public final AppImageAutoOptConfig getAppImageAutoOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AppImageAutoOptConfig) l0.a(new AppImageAutoOptConfig(false, 0, 0, 7, null), new qc());
    }

    @Override // com.larus.platform.api.m3
    public final oq9.b getAppImageUploadConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (oq9.b) l0.a(new oq9.b(0), new tb());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.h getAppLaunchFeedOptConfig() {
        e10 r0 = e10.a;
        pt9.a r1 = e10.w();
        boolean r2 = r1.a();
        long r3 = r1.e();
        boolean r5 = r1.c();
        pt9.f r4 = r1.b();
        if (r4 == null) goto L5;
        long r8 = r4.c();
    L6:
        pt9.f r6 = r1.b();
        if (r6 == null) goto L9;
        long r12 = r6.d();
    L11:
        return new hq9.h(r2, r3, r5, r8, r12, 8);
    L9:
        r12 = 0;
        goto L11
    L5:
        r8 = 0;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final hq9.l getAppsAIChatFrameworkConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new fv9.b();
        return new hq9.l(((fv9.a) l0.a(new fv9.a(null), new ja())).a());
    }

    @Override // com.larus.platform.api.m3
    public final m getAppsFrameworkConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new fv9.d();
        fv9.c r2 = (fv9.c) l0.a(fv9.d.a(), new pd());
        return new m(r2.a(), r2.e(), r2.c(), r2.b(), r2.d());
    }

    @Override // com.larus.platform.api.m3
    public final nq9.a getAppsSdkUgcBotConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new au9.b();
        au9.a r2 = (au9.a) l0.a(au9.b.a(), new id());
        String r3 = r2.a();
        if (r3 != null) goto L5;
        r3 = XmlPullParser.NO_NAMESPACE;
    L5:
        String[] r4 = r2.b();
        if (r4 == null) goto L8;
        List r5 = ArraysKt.toList(r4);
    L9:
        if (r5 != null) goto L12;
        r5 = CollectionsKt.emptyList();
    L12:
        return new nq9.a(r3, r5);
    L8:
        r5 = null;
        goto L9
    }

    @Override // com.larus.platform.api.m3
    public final long getAsrAnimDuration() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(50L, new v8())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.g1 getAsrCheckAudioConfig() {
        e10 r0 = e10.a;
        return (hq9.g1) l0.a(new hq9.g1(0, false), new com.larus.settings.value.h1());
    }

    @Override // com.larus.platform.api.m3
    public final lq9.b getAsrInputEntranceConfig() {
        e10 r0 = e10.a;
        return (lq9.b) l0.a(new lq9.b(0), new cc());
    }

    @Override // com.larus.platform.api.m3
    public final String getAsrStreamPostProcess() {
        e10 r0 = e10.a;
        return (String) l0.a("stream_post_process", new ix());
    }

    @Override // com.larus.platform.api.m3
    public final oq9.c getAttachmentAlbumDetectConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new bu9.c();
        return (oq9.c) l0.a(bu9.c.a(), new t4());
    }

    @Override // com.larus.platform.api.m3
    public final int getAudioCaptionDisplayChatContentScene() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1, new com.larus.settings.value.y())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final AudioPendingWaitConfig getAudioPendingWaitConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (AudioPendingWaitConfig) l0.a(new AudioPendingWaitConfig(false, false, 3, null), new qa());
    }

    @Override // com.larus.platform.api.m3
    public final fr9.a getAudioRecordConfig() {
        e10 r0 = e10.a;
        return (fr9.a) l0.a(new fr9.a(0), new z7());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.s getAudioStreamPlayerMechanismConfig() {
        e10 r0 = e10.a;
        return (hq9.s) l0.a(new hq9.s(0), new oo());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.b getAutoQuoteConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.g();
        return (com.larus.platform.model.chat.b) l0.a(new com.larus.platform.model.chat.b(0), new wt());
    }

    @Override // com.larus.platform.api.m3
    public final or9.c getAwemeVideoFeedConfig() {
        e10 r0 = e10.a;
        return (or9.c) l0.a(new or9.c(0), new qk());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.c getBDImageXUploadOptConfig() {
        e10 r0 = e10.a;
        du9.h r1 = (du9.h) l0.a(new du9.h(0), new pr());
        return new com.larus.platform.model.chat.c(r1.a(), r1.c(), r1.b());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.d getBDImageXUploaderConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.k();
        du9.j r2 = (du9.j) l0.a(du9.k.a(), new bm());
        return new com.larus.platform.model.chat.d(r2.h(), r2.g(), r2.e(), r2.f(), r2.a(), r2.b(), r2.d(), r2.c());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.e getBDVideoUploaderConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.m();
        du9.l r2 = (du9.l) l0.a(du9.m.a(), new zy());
        return new com.larus.platform.model.chat.e(r2.h(), r2.g(), r2.e(), r2.f(), r2.a(), r2.b(), r2.d(), r2.c());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.x getBasicExperienceAnrOptConfig() {
        e10 r0 = e10.a;
        return (hq9.x) l0.a(new hq9.x(0), new hm());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.y getBasicExperienceBugFixConfig() {
        e10 r0 = e10.a;
        qt9.n r1 = (qt9.n) l0.a(new qt9.n(0), new ll());
        return new hq9.y(r1.a(), r1.c(), r1.b(), r1.d());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.z getBasicExperienceCrashOptConfig() {
        e10 r0 = e10.a;
        return (hq9.z) l0.a(new hq9.z(0), new gw());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.a0 getBasicExperienceFeatureConfig() {
        e10 r0 = e10.a;
        qt9.q r1 = (qt9.q) l0.a(new qt9.q(0), new ec());
        return new hq9.a0(r1.a(), r1.c(), r1.b());
    }

    @Override // com.larus.platform.api.m3
    public final vq9.a getBlockRefactorConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new cv9.b();
        return (vq9.a) l0.a(cv9.b.a(), new nb());
    }

    @Override // com.larus.platform.api.m3
    public final BlockRequestDowngradeConfig getBlockRequestDowngradeConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (BlockRequestDowngradeConfig) l0.a(new BlockRequestDowngradeConfig(null, 1, null), new c3());
    }

    @Override // com.larus.platform.api.m3
    public final oq9.d getCameraCommonConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new bu9.e();
        oq9.d r2 = (oq9.d) l0.a(bu9.e.a(), new zi());
        return new oq9.d(r2.c(), r2.a(), r2.b());
    }

    @Override // com.larus.platform.api.m3
    public final oq9.f getCameraRecordFeatureConfig() {
        e10 r0 = e10.a;
        bu9.k r1 = (bu9.k) l0.a(new bu9.k(0), new bc());
        return new oq9.f(r1.b(), r1.d(), r1.a(), r1.c());
    }

    @Override // com.larus.platform.api.m3
    public final oq9.g getCameraResultTabConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new bu9.p();
        return (oq9.g) l0.a(bu9.p.a(), new z5());
    }

    @Override // com.larus.platform.api.m3
    public final CameraSettings getCameraSettings() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (CameraSettings) l0.a(new CameraSettings(0, 0, 0, 0, 0, 0, false, 127, null), new va());
    }

    @Override // com.larus.platform.api.m3
    public final boolean getCameraTopPaddingFixConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.i())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final ChatAwemeFeedConfig getChatAwemeFeedConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.p();
        return (ChatAwemeFeedConfig) l0.a(du9.p.a(), new com.larus.settings.value.i2());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.h getChatBlankScreenMonitorConfig() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.h) l0.a(new com.larus.platform.model.chat.h(0), new nc());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.i getChatFirstScreenOptConfig() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.i) l0.a(new com.larus.platform.model.chat.i(0), new q7());
    }

    @Override // com.larus.platform.api.m3
    public final gr9.a getChatListSearchConfig() {
        e10 r0 = e10.a;
        qt9.c0 r1 = e10.H();
        return new gr9.a(r1.e(), r1.d(), r1.h(), r1.a(), r1.b(), r1.c(), r1.g(), r1.f());
    }

    @Override // com.larus.platform.api.m3
    public final h0 getChatNavigatorConfig() {
        e10 r0 = e10.a;
        du9.w r1 = (du9.w) l0.a(new du9.w(0), new b6());
        return new h0(r1.c(), r1.e(), r1.d(), r1.h(), r1.g(), r1.f(), r1.a(), r1.b(), 768);
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.j getChatPageLoadOptConfig() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.j) l0.a(new com.larus.platform.model.chat.j(0), new q5());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.k getChatReadPositionBugfixConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.z();
        return (com.larus.platform.model.chat.k) l0.a(new com.larus.platform.model.chat.k(0), new ri());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.l0 getCommentClientConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.l0) l0.a(new hq9.l0(0), new iq());
    }

    @Override // com.larus.platform.api.m3
    public final HashMap<String, hq9.n0> getCommonButtonV2AICreationConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (HashMap) l0.a(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("gen_video_by_downgraded_model", new hq9.n0("creation_confirm")), TuplesKt.to("creation_portrait_video_auth_confirm", new hq9.n0("real_person_video_auth"))}), new rz());
    }

    @Override // com.larus.platform.api.m3
    public final sq9.a getCommunityRecommendRequestConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (sq9.a) l0.a(new sq9.a(0), new vh());
    }

    @Override // com.larus.platform.api.m3
    public final ContinuousSpeechUIConfig getContinuousSpeechUIConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        ContinuousSpeechUIConfig.Companion.getClass();
        return (ContinuousSpeechUIConfig) l0.a(ContinuousSpeechUIConfig.access$getDEFAULT$cp(), new ss());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.r0 getCreationCanvasClientConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        qt9.i0 r2 = (qt9.i0) l0.a(new qt9.i0(), new um());
        Long r3 = r2.generateTimeoutMs;
        if (r3 == null) goto L5;
        long r4 = r3.longValue();
    L6:
        Integer r5 = r2.streamPullRetryCount;
        if (r5 == null) goto L9;
        int r6 = r5.intValue();
    L10:
        Long r7 = r2.streamPullChunkTimeoutMs;
        if (r7 == null) goto L13;
        long r8 = r7.longValue();
    L14:
        Long r9 = r2.streamPullConnectTimeoutMs;
        if (r9 == null) goto L17;
        long r10 = r9.longValue();
    L18:
        Long r11 = r2.streamPullIntervalTimeoutMs;
        if (r11 == null) goto L21;
        long r12 = r11.longValue();
    L22:
        Long r13 = r2.streamPullWriteTimeoutMs;
        if (r13 == null) goto L25;
        long r14 = r13.longValue();
    L26:
        Long r15 = r2.streamPullProtectTimeoutMs;
        if (r15 == null) goto L29;
        long r16 = r15.longValue();
    L30:
        long r17 = r16;
        Integer r18 = r2.maxGenerateCountPerRound;
        if (r18 == null) goto L33;
        int r19 = r18.intValue();
    L35:
        return new hq9.r0(r4, r6, r8, r10, r12, r14, r17, r19);
    L33:
        r19 = 20;
        goto L35
    L29:
        r16 = 180000;
        goto L30
    L25:
        r14 = 60000;
        goto L26
    L21:
        r12 = 60000;
        goto L22
    L17:
        r10 = 60000;
        goto L18
    L13:
        r8 = 60000;
        goto L14
    L9:
        r6 = 10;
        goto L10
    L5:
        r4 = 60000;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final hq9.s0 getCreationCanvasConfig() {
        if (AccountService.a.isEnterpriseAccount() == true) goto L5;
        e10 r0 = e10.a;
        int r1 = l0.a;
        qt9.k0 r2 = (qt9.k0) l0.a(new qt9.k0(), new q0());
        return new hq9.s0(r2.instructionMode, r2.defaultOpenTabLabel);
    L5:
        return new hq9.s0(null, null);
    }

    @Override // com.larus.platform.api.m3
    public final sq9.d getCreationCommentConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (sq9.d) l0.a(new sq9.d(false, false), new tp());
    }

    @Override // com.larus.platform.api.m3
    public final sq9.e getCreationDetailLayoutConfig() {
        e10 r0 = e10.a;
        boolean r1 = false;
        sq9.e r2 = (sq9.e) l0.a(new sq9.e(0), new ab());
        int r3 = r2.c();
        if (r3 >= 0) goto L5;
    L7:
        if (r1 == false) goto L10;
        return r2;
    L10:
        return sq9.e.a(r2);
    L5:
        if (r3 >= 7) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.larus.platform.api.m3
    public final int getCreationDosameLandingType() {
        e10 r0 = e10.a;
        return e10.K();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.t0 getCreationDownloaderConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        hq9.t0 r2 = (hq9.t0) l0.a(new hq9.t0(0), new jt());
        return new hq9.t0(r2.callbackTimeoutMs, r2.retryCount);
    }

    @Override // com.larus.platform.api.m3
    public final sq9.f getCreationEditControlConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (sq9.f) l0.a(new sq9.f(0), new zc());
    }

    @Override // com.larus.platform.api.m3
    public final sq9.h getCreationExtendVideoConfig() {
        e10 r0 = e10.a;
        return (sq9.h) l0.a(new sq9.h(0), new t9());
    }

    @Override // com.larus.platform.api.m3
    public final boolean getCreationFeedLandingTabOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.h())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final sq9.k getCreationMakeSameConfig() {
        e10 r0 = e10.a;
        return (sq9.k) l0.a(new sq9.k(0), new pi());
    }

    @Override // com.larus.platform.api.m3
    public final sq9.l getCreationMakeSameConfigV2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (sq9.l) l0.a(new sq9.l(false, false), new uj());
    }

    @Override // com.larus.platform.api.m3
    public final u0 getCreationNotificationConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        u0 r2 = (u0) l0.a(new u0(0), new rn());
        Boolean r3 = r2.showNotification;
        if (r3 == null) goto L5;
        boolean r4 = r3.booleanValue();
    L6:
        Boolean r5 = Boolean.valueOf(r4);
        Long r6 = r2.expireTime;
        if (r6 == null) goto L9;
        long r7 = r6.longValue();
    L10:
        Long r8 = Long.valueOf(r7);
        Long r9 = r2.refreshQueuingIntervalSec;
        if (r9 == null) goto L13;
        long r10 = r9.longValue();
    L14:
        Long r11 = Long.valueOf(r10);
        Long r12 = r2.refreshGeneratingIntervalSec;
        if (r12 == null) goto L17;
        long r13 = r12.longValue();
    L18:
        Long r14 = Long.valueOf(r13);
        Double r15 = r2.progressSpeed;
        if (r15 == null) goto L21;
        double r16 = r15.doubleValue();
    L23:
        return new u0(r5, r8, r11, r14, Double.valueOf(r16));
    L21:
        r16 = 0.05d;
        goto L23
    L17:
        r13 = 1;
        goto L18
    L13:
        r10 = 5;
        goto L14
    L9:
        r7 = 21600;
        goto L10
    L5:
        r4 = true;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final sq9.m getCreationPageSwipeAuthorConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (sq9.m) l0.a(new sq9.m(false), new er());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.n getCreationPreviewPerformanceOptConfig() {
        e10 r0 = e10.a;
        du9.c0 r1 = e10.L();
        return new com.larus.platform.model.chat.n(r1.l(), r1.a(), r1.b(), r1.j(), r1.i(), r1.g(), r1.e(), r1.d(), r1.f(), r1.n(), r1.m(), r1.c(), r1.h(), r1.k());
    }

    @Override // com.larus.platform.api.m3
    public final sq9.n getCreationPublishConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (sq9.n) l0.a(new sq9.n(false, false), new a6());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.v0 getCreationShareSettings() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.v0) l0.a(new hq9.v0(0), new be());
    }

    @Override // com.larus.platform.api.m3
    public final hu9.s getCreationUpdateDialogConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hu9.s) l0.a(new hu9.s(null), new yr());
    }

    @Override // com.larus.platform.api.m3
    public final long getCreationVideoMdlDownloadTimeoutMs() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(5000L, new ex())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final kq9.l getCreationWeakNetworkConfig() {
        e10 r0 = e10.a;
        return (kq9.l) l0.a(new kq9.l(0), new bi());
    }

    @Override // com.larus.platform.api.m3
    public final int getDarkModeDefault() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1, new pb())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final String getDefaultNewConversationMode() {
        e10 r0 = e10.a;
        String r1 = (String) l0.a(XmlPullParser.NO_NAMESPACE, new oi());
        if (Intrinsics.areEqual(r1, "chat") == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r1 = null;
    L12:
        if (r1 != null) goto L17;
        if (AccountService.a.isEnterpriseAccount() == true) goto L19;
        return "chat";
    L19:
        return "office";
    L17:
        return r1;
    L5:
        if (Intrinsics.areEqual(r1, "office") == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.platform.api.m3
    public final DelayRequestDowngradeConfig getDelayRequestDowngradeConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (DelayRequestDowngradeConfig) l0.a(new DelayRequestDowngradeConfig(null, 1, null), new vi());
    }

    @Override // com.larus.platform.api.m3
    public final String getDeviceId() {
        return IApplog.a.getDeviceId();
    }

    @Override // com.larus.platform.api.m3
    public final mq9.a getDigitalAvatarAuthStyleConfigV2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new wt9.a();
        return (mq9.a) l0.a(wt9.a.a(), new e3());
    }

    @Override // com.larus.platform.api.m3
    public final mq9.c getDigitalAvatarVideoRecordingConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new wt9.c();
        return (mq9.c) l0.a(wt9.c.a(), new jg());
    }

    @Override // com.larus.platform.api.m3
    public final mq9.d getDigitalAvatarVideoRecordingConfigV2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new wt9.d();
        return (mq9.d) l0.a(wt9.d.a(), new dq());
    }

    @Override // com.larus.platform.api.m3
    public final tq9.d getDocFeatureEntranceConfig() {
        e10 r0 = e10.a;
        return new tq9.d(((mu9.g) l0.a(new mu9.g(0), new ya())).a());
    }

    @Override // com.larus.platform.api.m3
    public final tq9.e getDocFusionConfig() {
        e10 r0 = e10.a;
        String r1 = ((mu9.i) l0.a(new mu9.i(0), new yg())).a();
        if (r1 == null) goto L5;
        String r2 = r1.toLowerCase(Locale.getDefault());
    L7:
        return new tq9.e(Intrinsics.areEqual(r2, "true"));
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.platform.api.m3
    public final tq9.f getDocFusionConfigV2() {
        e10 r0 = e10.a;
        mu9.k r1 = (mu9.k) l0.a(new mu9.k(0), new u3());
        return new tq9.f(r1.a(), r1.c(), r1.b(), r1.d());
    }

    @Override // com.larus.platform.api.m3
    public final tq9.g getDocOfflineCreateConfig() {
        e10 r0 = e10.a;
        mu9.m r1 = (mu9.m) l0.a(new mu9.m(0), new z2());
        return new tq9.g(r1.b(), r1.d(), r1.a(), r1.c());
    }

    @Override // com.larus.platform.api.m3
    public final boolean getDoraCdmDisableConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new p1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean getDoraCdmFeatureSwitchConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.a2())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.o getDoraGUpdateConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        nu9.k r2 = (nu9.k) l0.a(new nu9.k(0), new os());
        nu9.z r3 = r2.c();
        if (r3 == null) goto L5;
        lq9.t r9 = new lq9.t(r3.f(), r3.e(), r3.b(), r3.a(), r3.d(), r3.c());
    L7:
        return new lq9.o(r2.a(), r9, r2.b());
    L5:
        r9 = null;
        goto L7
    }

    @Override // com.larus.platform.api.m3
    public final boolean getDoraKeepAliveMethodsConfig() {
        e10 r0 = e10.a;
        return e10.N();
    }

    @Override // com.larus.platform.api.m3
    public final FlowDoraSamiConfigModel getDoraSamiConfig() {
        e10 r0 = e10.a;
        nu9.r r1 = e10.P();
        int[] r2 = r1.a();
        int r4 = r1.c();
        boolean r6 = r1.e();
        return new FlowDoraSamiConfigModel(r2, null, r4, r1.d(), r6, r1.f(), r1.b(), 2, null);
    }

    @Override // com.larus.platform.api.m3
    public final List<z0> getDoraSimulSupportLangConfigList() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new ji());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.q getDoubaoDisclaimerConfig() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.q) l0.a(new com.larus.platform.model.chat.q(0), new cd());
    }

    @Override // com.larus.platform.api.m3
    public final uq9.f getECommerceAuthConfig() {
        e10 r0 = e10.a;
        return e10.R();
    }

    @Override // com.larus.platform.api.m3
    public final ECommerceProductCardPreloadConfig getECommerceProductCardPreloadConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (ECommerceProductCardPreloadConfig) l0.a(new ECommerceProductCardPreloadConfig(0, 0.0d, 0, 7, null), new tx());
    }

    @Override // com.larus.platform.api.m3
    public final ECommerceSettingsConfig getECommerceSettingsConfig() {
        FLogger.a.i("ECommercePluginStatusEntrance", "getECommerceSettingsConfig");
        e10 r0 = e10.a;
        return e10.S();
    }

    @Override // com.larus.platform.api.m3
    public final JSONObject getEcomBcmSettings() {
        int r0 = com.larus.settings.btm.a.a;
        JSONObject r1 = IEcomBcmSettings.Companion.getEcomBcmSettings();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new JSONObject();
    }

    @Override // com.larus.platform.api.m3
    public final uq9.j getEcomSaaSAIInputConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new pu9.e();
        return (uq9.j) l0.a(new uq9.j(0), new jb());
    }

    @Override // com.larus.platform.api.m3
    public final oq9.h getEduCameraConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new bu9.s();
        return (oq9.h) l0.a(bu9.s.a(), new w5());
    }

    @Override // com.larus.platform.api.m3
    public final int getEduDefaultQuestionMode() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new l8())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final oq9.i getEduIntentionCameraConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        bu9.t r2 = (bu9.t) l0.a(new bu9.t(false, false, false, false), new fg());
        return new oq9.i(r2.a(), r2.c(), r2.b(), r2.d());
    }

    @Override // com.larus.platform.api.m3
    public final int getEnableModelTrainingBySpecificType() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1, new w6())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final List<String> getEnterVideoCallWhiteList() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new y4());
    }

    @Override // com.larus.platform.api.m3
    public final kq9.n getFastAlbumMultiSelectConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new tt9.a();
        return (kq9.n) l0.a(new kq9.n(0), new o8());
    }

    @Override // com.larus.platform.api.m3
    public final e1 getFirstInstallOptConfig() {
        e10 r0 = e10.a;
        return e10.V();
    }

    @Override // com.larus.platform.api.m3
    public final f1 getFloatWindowConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (f1) l0.a(new f1(null), new ce());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.h1 getFlowAsrClientRetryStrategy() {
        e10 r0 = e10.a;
        return (hq9.h1) l0.a(new hq9.h1(null, null), new qt());
    }

    @Override // com.larus.platform.api.m3
    public final String getFlowDeviceModelScore() {
        e10 r0 = e10.a;
        return (String) l0.a(XmlPullParser.NO_NAMESPACE, new b9());
    }

    @Override // com.larus.platform.api.m3
    public final FlowDowngradeToastConfig getFlowDowngradeToastConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (FlowDowngradeToastConfig) l0.a(new FlowDowngradeToastConfig(null, null, null, null, 15, null), new zh());
    }

    @Override // com.larus.platform.api.m3
    public final uq9.k getFlowECommerceSaasSdkConfig() {
        e10 r0 = e10.a;
        return (uq9.k) l0.a(new uq9.k(null), new v00());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.t getFlowMultiUploadConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new o0();
        du9.n0 r2 = (du9.n0) l0.a(o0.a(), new com.larus.settings.value.o1());
        com.larus.platform.model.chat.t r3 = new com.larus.platform.model.chat.t(0);
        com.larus.platform.model.chat.s0 r4 = r3.m();
        if (r4 != null) goto L5;
        r4 = new com.larus.platform.model.chat.s0(0);
    L5:
        com.larus.platform.model.chat.r0 r5 = r3.j();
        if (r5 != null) goto L8;
        r5 = new com.larus.platform.model.chat.r0(0);
    L8:
        com.larus.platform.model.chat.t0 r6 = r3.n();
        if (r6 != null) goto L11;
        r6 = new com.larus.platform.model.chat.t0(0);
    L11:
        com.larus.platform.model.chat.u0 r7 = r6.a();
        if (r7 != null) goto L14;
        r7 = new com.larus.platform.model.chat.u0(0);
    L14:
        com.larus.platform.model.chat.v0 r8 = r6.b();
        if (r8 != null) goto L17;
        r8 = new com.larus.platform.model.chat.v0(0);
    L17:
        com.larus.platform.model.chat.r r9 = r3.a();
        if (r9 != null) goto L20;
        r9 = new com.larus.platform.model.chat.r(0);
    L20:
        List r10 = r2.k();
        if (r10 != null) goto L23;
        r10 = r3.k();
    L23:
        List r11 = r10;
        List r12 = r2.b();
        Long r13 = r2.l();
        if (r13 != null) goto L26;
        Long r14 = r3.l();
    L27:
        du9.q2 r15 = r2.m();
        if (r15 == null) goto L31;
        Long r16 = r15.b();
        if (r16 == null) goto L31;
    L32:
        Long r17 = r16;
        du9.q2 r18 = r2.m();
        if (r18 == null) goto L36;
        Integer r19 = r18.a();
        if (r19 == null) goto L36;
    L37:
        Integer r110 = r19;
        du9.q2 r20 = r2.m();
        if (r20 == null) goto L41;
        Long r21 = r20.d();
        if (r21 == null) goto L41;
    L42:
        Long r111 = r21;
        du9.q2 r22 = r2.m();
        if (r22 == null) goto L46;
        Integer r23 = r22.c();
        if (r23 == null) goto L46;
    L47:
        Integer r112 = r23;
        du9.q2 r24 = r2.m();
        if (r24 == null) goto L53;
        Integer r25 = r24.e();
        if (r25 == null) goto L53;
        Integer r113 = r25;
    L54:
        com.larus.platform.model.chat.s0 r26 = new com.larus.platform.model.chat.s0(r17, r110, r111, r112, r113);
        du9.p2 r28 = r2.j();
        if (r28 == null) goto L58;
        List r29 = r28.a();
        if (r29 == null) goto L58;
    L59:
        du9.p2 r30 = r2.j();
        if (r30 == null) goto L63;
        Long r31 = r30.d();
        if (r31 == null) goto L63;
    L64:
        du9.p2 r114 = r2.j();
        if (r114 == null) goto L68;
        Integer r115 = r114.b();
        if (r115 == null) goto L68;
    L69:
        du9.p2 r116 = r2.j();
        if (r116 == null) goto L73;
        Long r117 = r116.c();
        if (r117 == null) goto L73;
    L74:
        com.larus.platform.model.chat.r0 r118 = new com.larus.platform.model.chat.r0(r29, r31, r115, r117);
        boolean r119 = r2.c();
        r2 r32 = r2.n();
        if (r32 == null) goto L80;
        s2 r33 = r32.a();
        if (r33 == null) goto L80;
        Long r34 = r33.i();
        if (r34 == null) goto L80;
    L81:
        Long r120 = r34;
        r2 r35 = r2.n();
        if (r35 == null) goto L87;
        s2 r36 = r35.a();
        if (r36 == null) goto L87;
        Integer r37 = r36.j();
        if (r37 == null) goto L87;
    L88:
        Integer r121 = r37;
        r2 r38 = r2.n();
        if (r38 == null) goto L94;
        s2 r39 = r38.a();
        if (r39 == null) goto L94;
        Integer r40 = r39.h();
        if (r40 == null) goto L94;
    L95:
        Integer r122 = r40;
        r2 r41 = r2.n();
        if (r41 == null) goto L101;
        s2 r42 = r41.a();
        if (r42 == null) goto L101;
        Integer r43 = r42.g();
        if (r43 == null) goto L101;
    L102:
        Integer r210 = r43;
        r2 r44 = r2.n();
        if (r44 == null) goto L108;
        s2 r45 = r44.a();
        if (r45 == null) goto L108;
        Long r46 = r45.d();
        if (r46 == null) goto L108;
    L109:
        Long r211 = r46;
        r2 r47 = r2.n();
        if (r47 == null) goto L115;
        s2 r48 = r47.a();
        if (r48 == null) goto L115;
        Long r49 = r48.f();
        if (r49 == null) goto L115;
    L116:
        Long r212 = r49;
        r2 r50 = r2.n();
        if (r50 == null) goto L122;
        s2 r51 = r50.a();
        if (r51 == null) goto L122;
        Integer r52 = r51.e();
        if (r52 == null) goto L122;
    L123:
        Integer r213 = r52;
        r2 r53 = r2.n();
        if (r53 == null) goto L129;
        s2 r54 = r53.a();
        if (r54 == null) goto L129;
        Integer r55 = r54.c();
        if (r55 == null) goto L129;
    L130:
        Integer r214 = r55;
        r2 r56 = r2.n();
        if (r56 == null) goto L136;
        s2 r57 = r56.a();
        if (r57 == null) goto L136;
        List r58 = r57.a();
        if (r58 == null) goto L136;
    L137:
        List r215 = r58;
        r2 r59 = r2.n();
        if (r59 == null) goto L143;
        s2 r60 = r59.a();
        if (r60 == null) goto L143;
        List r61 = r60.b();
        if (r61 == null) goto L143;
    L144:
        com.larus.platform.model.chat.u0 r62 = new com.larus.platform.model.chat.u0(r120, r121, r122, r210, r211, r212, r213, r214, r215, r61);
        r2 r63 = r2.n();
        if (r63 == null) goto L149;
        du9.t2 r64 = r63.b();
        if (r64 == null) goto L149;
        boolean r65 = r64.a();
    L150:
        boolean r216 = r65;
        r2 r66 = r2.n();
        if (r66 == null) goto L156;
        du9.t2 r67 = r66.b();
        if (r67 == null) goto L156;
        Integer r68 = r67.g();
        if (r68 == null) goto L156;
    L157:
        Integer r217 = r68;
        r2 r69 = r2.n();
        if (r69 == null) goto L163;
        du9.t2 r70 = r69.b();
        if (r70 == null) goto L163;
        Integer r71 = r70.e();
        if (r71 == null) goto L163;
    L164:
        Integer r310 = r71;
        r2 r72 = r2.n();
        if (r72 == null) goto L170;
        du9.t2 r73 = r72.b();
        if (r73 == null) goto L170;
        Integer r74 = r73.d();
        if (r74 == null) goto L170;
    L171:
        Integer r311 = r74;
        r2 r75 = r2.n();
        if (r75 == null) goto L177;
        du9.t2 r76 = r75.b();
        if (r76 == null) goto L177;
        Long r77 = r76.b();
        if (r77 == null) goto L177;
    L178:
        Long r312 = r77;
        r2 r78 = r2.n();
        if (r78 == null) goto L184;
        du9.t2 r79 = r78.b();
        if (r79 == null) goto L184;
        String r80 = r79.c();
        if (r80 == null) goto L184;
    L185:
        String r313 = r80;
        r2 r81 = r2.n();
        if (r81 == null) goto L193;
        du9.t2 r82 = r81.b();
        if (r82 == null) goto L193;
        String r83 = r82.f();
        if (r83 == null) goto L193;
        String r314 = r83;
    L194:
        com.larus.platform.model.chat.t0 r123 = new com.larus.platform.model.chat.t0(r62, new com.larus.platform.model.chat.v0(r216, r217, r310, r311, r312, r313, r314));
        du9.j0 r84 = r2.a();
        if (r84 == null) goto L198;
        Long r85 = r84.a();
        if (r85 == null) goto L198;
    L200:
        return new com.larus.platform.model.chat.t(r11, r12, r14, r26, r118, r119, r123, new com.larus.platform.model.chat.r(r85), r2.h(), r2.g(), r2.e(), r2.d(), r2.i(), r2.f());
    L198:
        r85 = r9.a();
    L193:
        r314 = r8.f();
    L184:
        r80 = r8.c();
    L177:
        r77 = r8.b();
    L170:
        r74 = r8.d();
    L163:
        r71 = r8.e();
    L156:
        r68 = r8.g();
    L149:
        r65 = r8.a();
    L143:
        r61 = r7.b();
    L136:
        r58 = r7.a();
    L129:
        r55 = r7.c();
    L122:
        r52 = r7.e();
    L115:
        r49 = r7.f();
    L108:
        r46 = r7.d();
    L101:
        r43 = r7.g();
    L94:
        r40 = r7.h();
    L87:
        r37 = r7.j();
    L80:
        r34 = r7.i();
    L73:
        r117 = r5.d();
    L68:
        r115 = r5.c();
    L63:
        r31 = r5.e();
    L58:
        r29 = r5.b();
    L53:
        r113 = r4.e();
    L46:
        r23 = r4.c();
    L41:
        r21 = r4.d();
    L36:
        r19 = r4.a();
    L31:
        r16 = r4.b();
        goto L32
    L26:
        r14 = r13;
        goto L27
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.u getFlowVideoComprehendConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.q0();
        return new com.larus.platform.model.chat.u(((du9.p0) l0.a(new du9.p0(0), new vr())).a());
    }

    @Override // com.larus.platform.api.m3
    public final ir9.c getFontSizeAllowConfig() {
        e10 r0 = e10.a;
        return e10.q();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.k1 getFrequentMethodCallOptConfig() {
        e10 r0 = e10.a;
        return e10.W();
    }

    @Override // com.larus.platform.api.m3
    public final l1 getFrontierConnectInfo() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        su9.a r2 = (su9.a) l0.a(su9.b.a(), new tg());
        Integer r3 = r2.e();
        String r4 = r2.a();
        if (r4 != null) goto L5;
        String r5 = XmlPullParser.NO_NAMESPACE;
    L6:
        String r6 = r2.b();
        if (r6 != null) goto L9;
        String r7 = XmlPullParser.NO_NAMESPACE;
    L10:
        String r8 = r5;
        String r9 = r7;
        return new l1(r3, r8, r9, r2.d(), r2.c());
    L9:
        r7 = r6;
        goto L10
    L5:
        r5 = r4;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final hq9.m1 getFrontierOptConfig() {
        e10 r0 = e10.a;
        su9.d r1 = (su9.d) l0.a(new su9.d(0), new gh());
        return new hq9.m1(r1.e(), r1.c(), r1.d(), r1.b(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final GlobalFeedbackConfig getGlobalFeedbackConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (GlobalFeedbackConfig) l0.a(new GlobalFeedbackConfig(false, 1, null), new f7());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.v getGoMaxReadPositionConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.v0();
        return (com.larus.platform.model.chat.v) l0.a(du9.v0.a(), new d3());
    }

    @Override // com.larus.platform.api.m3
    public final boolean getHitCallDirectEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new da())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final r1 getI2iImageStyleConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        Boolean r2 = ((u1) l0.a(new u1(), new at())).needRefresh;
        if (r2 == null) goto L5;
        boolean r3 = r2.booleanValue();
    L7:
        return new r1(r3);
    L5:
        r3 = false;
        goto L7
    }

    @Override // com.larus.platform.api.m3
    public final s1 getImageEditUploadConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        qt9.x1 r2 = (qt9.x1) l0.a(new qt9.x1(), new z6());
        Integer r3 = r2.d();
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L6:
        Integer r5 = r2.b();
        if (r5 == null) goto L9;
        int r6 = r5.intValue();
    L10:
        Integer r7 = r2.a();
        if (r7 == null) goto L13;
        int r8 = r7.intValue();
    L15:
        return new s1(r4, r6, r8, r2.c());
    L13:
        r8 = 100;
        goto L15
    L9:
        r6 = 4096;
        goto L10
    L5:
        r4 = 2160;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final sq9.w getImageInspireConfig() {
        e10 r0 = e10.a;
        return new sq9.w(((iu9.a) l0.a(new iu9.a(0), new km())).a());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.u1 getImageInstantUploadConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.u1) l0.a(new hq9.u1(null), new un());
    }

    @Override // com.larus.platform.api.m3
    public final kq9.r getImageUploadDuplicateStatConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (kq9.r) l0.a(new kq9.r(0), new q9());
    }

    @Override // com.larus.platform.api.m3
    public final String getImgCreationFallbackAnchorName() {
        e10 r0 = e10.a;
        return (String) l0.a("anchor_name_default_pic", new com.larus.settings.value.x());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.w getInputBottomAlbumHeightConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.y0();
        return (com.larus.platform.model.chat.w) l0.a(du9.y0.a(), new ac());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.y1 getInstructionEntranceShowConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        InstructionEntranceShowConfig r2 = (InstructionEntranceShowConfig) l0.a(new InstructionEntranceShowConfig(false, false, false, 7, null), new com.larus.settings.value.r1());
        return new hq9.y1(r2.getShowByClickPlus(), r2.getShowWithClearContext(), r2.getShowAlways());
    }

    @Override // com.larus.platform.api.m3
    public final b2 getLarkBitableConfig() {
        e10 r0 = e10.a;
        return (b2) l0.a(new b2(0), new com.larus.settings.value.s());
    }

    @Override // com.larus.platform.api.m3
    public final String getLarkCliAppId() {
        e10 r0 = e10.a;
        return (String) l0.a(XmlPullParser.NO_NAMESPACE, new f8());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.c2 getLarkDriveConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.c2) l0.a(new hq9.c2(null), new af());
    }

    @Override // com.larus.platform.api.m3
    public final d2 getLarkDriveConfigV2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (d2) l0.a(new d2(null), new sr());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.i2 getLarkMixedFeedConfig() {
        e10 r0 = e10.a;
        return (hq9.i2) l0.a(new hq9.i2(0), new i9());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.j2 getLarkMixedFeedMonitorConfig() {
        e10 r0 = e10.a;
        return (hq9.j2) l0.a(new hq9.j2(0), new g3());
    }

    @Override // com.larus.platform.api.m3
    public final Map<String, String> getLarkOfficeAppLinkMapping() {
        e10 r0 = e10.a;
        return e10.a0();
    }

    @Override // com.larus.platform.api.m3
    public final k2 getLarkSocialBlockConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (k2) l0.a(new k2(null), new za());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.t2 getLarkSocialInitConfig() {
        e10 r0 = e10.a;
        return (hq9.t2) l0.a(new hq9.t2(0), new uv());
    }

    @Override // com.larus.platform.api.m3
    public final List<String> getLarkSocialTenantIdList() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new o4());
    }

    @Override // com.larus.platform.api.m3
    public final xq9.a getLatexEngineConfig() {
        e10 r0 = e10.a;
        return (xq9.a) l0.a(new xq9.a(0), new dy());
    }

    @Override // com.larus.platform.api.m3
    public final vq9.b getLocalLifeConfig() {
        e10 r0 = e10.a;
        return e10.b0();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.r getLoudnessConfig() {
        e10 r0 = e10.a;
        b0 r1 = (b0) l0.a(new b0(0), new cg());
        return new lq9.r(r1.c(), r1.a(), r1.b());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.c3 getLynxVerifyConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        LynxVerifyConfig r2 = (LynxVerifyConfig) l0.a(new LynxVerifyConfig(false, false, null, 7, null), new dw());
        boolean r3 = r2.getEnableIntercept();
        boolean r4 = r2.getEnableReport();
        List r5 = r2.getInnerDomains();
        if (r5 == null) goto L5;
        List r6 = CollectionsKt.filterNotNull(r5);
    L7:
        return new hq9.c3(r3, r4, r6);
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.larus.platform.api.m3
    public final hq9.d3 getMainBotSloMonitorConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.d3) l0.a(new hq9.d3(null), new fu());
    }

    @Override // com.larus.platform.api.m3
    public final oq9.j getMainCameraDetectConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new bu9.y();
        return (oq9.j) l0.a(bu9.y.a(), new so());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.e3 getMarkdownCodeRenderConfig() {
        e10 r0 = e10.a;
        ot9.o r1 = e10.e0();
        boolean r2 = e10.e0().g();
        List r3 = e10.e0().d();
        if (r3 == null) goto L5;
        List r4 = CollectionsKt.filterNotNull(r3);
    L6:
        boolean r5 = e10.e0().f();
        int r6 = r1.b();
        int r7 = r1.a();
        int r8 = r1.l();
        int r9 = r1.k();
        String r10 = r1.m();
        List r11 = r1.c();
        if (r11 == null) goto L9;
        List r12 = CollectionsKt.filterNotNull(r11);
    L11:
        return new hq9.e3(r2, r4, r5, r6, r7, r8, r9, r10, r12, r1.j(), r1.n(), r1.i(), r1.h(), r1.o(), r1.e());
    L9:
        r12 = null;
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final Map<String, Object> getMarkdownCssConfig() {
        e10 r0 = e10.a;
        String r1 = (String) l0.a("{\"ugc_lowlight_style\":{\"default\":{\"light\":{\"color\":\"#000000FF\",\"font-style\":\"italic\",\"font-weight\":\"normal\"},\"dark\":{\"color\":\"#FFFFFFFF\",\"font-style\":\"italic\",\"font-weight\":\"normal\"}},\"style1\":{\"light\":{\"color\":\"#666666FF\",\"font-style\":\"italic\",\"font-weight\":\"normal\"},\"dark\":{\"color\":\"#ffffffb3\",\"font-style\":\"italic\",\"font-weight\":\"normal\"}},\"style2\":{\"light\":{\"color\":\"#666666FF\",\"font-style\":\"normal\",\"font-weight\":\"normal\"},\"dark\":{\"color\":\"#ffffffb3\",\"font-style\":\"normal\",\"font-weight\":\"normal\"}}}}", new yx());
        return (Map) new Gson().fromJson(r1, new a().getType());
    L5:
        return null;
    }

    @Override // com.larus.platform.api.m3
    public final f3 getMarkdownOptimizeConfig() {
        e10 r0 = e10.a;
        boolean r1 = e10.f0().l();
        boolean r2 = e10.f0().n();
        int r3 = e10.f0().j();
        int r4 = e10.f0().a();
        int r5 = e10.f0().k();
        int r6 = l0.a;
        return new f3(r1, r2, r3, r4, r5, ((Boolean) l0.a(Boolean.FALSE, new k4())).booleanValue(), e10.f0().i(), e10.f0().f(), e10.f0().c(), e10.f0().e(), e10.f0().h(), e10.f0().d(), e10.f0().m(), e10.f0().b(), e10.f0().g());
    }

    @Override // com.larus.platform.api.m3
    public final xq9.b getMarkdownTableRenderConfig() {
        e10 r0 = e10.a;
        return (xq9.b) l0.a(new xq9.b(0), new n9());
    }

    @Override // com.larus.platform.api.m3
    public final d0 getMessageListOptConfig() {
        e10 r0 = e10.a;
        return (d0) l0.a(new d0(0), new c5());
    }

    @Override // com.larus.platform.api.m3
    public final MessageMarkdownSettingsConfig getMessageMarkdownSettingsConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        MessageMarkdownSettingsConfig.Companion.getClass();
        MessageMarkdownSettingsConfig r2 = (MessageMarkdownSettingsConfig) l0.a(new MessageMarkdownSettingsConfig(false), new wd());
        if (r2.getEnableUpstreamCellMarkdown() == true) goto L10;
        Boolean r3 = Boolean.FALSE;
        if (((Boolean) l0.a(r3, new ma())).booleanValue() == true) goto L9;
        if (((Boolean) l0.a(r3, new k9())).booleanValue() == true) goto L9;
        return r2;
    L9:
        return r2.copy(true);
    L10:
        return r2;
    }

    @Override // com.larus.platform.api.m3
    public final long getMessageRenderHangInterval() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(3000L, new p3())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final MockRequestDowngradeConfig getMockRequestDowngradeConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (MockRequestDowngradeConfig) l0.a(new MockRequestDowngradeConfig(null, 1, null), new f00());
    }

    @Override // com.larus.platform.api.m3
    public final h3 getModelFilingInfoConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new hv9.a();
        return (h3) l0.a(new h3(null), new p5());
    }

    @Override // com.larus.platform.api.m3
    public final int getMultiCameraCaptureScene() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new tm())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final j3 getMultiTaskEntranceConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new iv9.b();
        iv9.a r2 = (iv9.a) l0.a(iv9.b.a(), new y5());
        return new j3(r2.c(), r2.e(), r2.b(), r2.f(), r2.d(), r2.a());
    }

    @Override // com.larus.platform.api.m3
    public final zq9.a getMultiTaskManagementConfig() {
        e10 r0 = e10.a;
        return (zq9.a) l0.a(new zq9.a(0), new com.larus.settings.value.d1());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.g0 getMultimodalConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.s1();
        return new com.larus.platform.model.chat.g0(((du9.r1) l0.a(new du9.r1(0), new hb())).a());
    }

    @Override // com.larus.platform.api.m3
    public final k3 getMusicCreateConfig() {
        e10 r0 = e10.a;
        kv9.a r1 = (kv9.a) l0.a(new kv9.a(0), new fc());
        return new k3(r1.a(), r1.b(), r1.c(), r1.d(), r1.e());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.l3 getMusicSaveConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        MusicSaveConfig r2 = (MusicSaveConfig) l0.a(new MusicSaveConfig(null, null, null, null, 15, null), new j9());
        Integer r3 = r2.getMinVersionUseCanvasDraw();
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L6:
        Integer r5 = r2.getFramesPerSecond();
        if (r5 == null) goto L9;
        int r6 = r5.intValue();
    L10:
        Long r7 = r2.getDrainTimeoutMs();
        if (r7 == null) goto L13;
        long r8 = r7.longValue();
    L14:
        Boolean r9 = r2.getFixSaveMusicError();
        if (r9 == null) goto L17;
        boolean r10 = r9.booleanValue();
    L19:
        return new hq9.l3(r4, r6, r8, r10);
    L17:
        r10 = false;
        goto L19
    L13:
        r8 = 1000;
        goto L14
    L9:
        r6 = 5;
        goto L10
    L5:
        r4 = 26;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final kq9.s getNewAlbumMediaFilterConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new tt9.b();
        return (kq9.s) l0.a(new kq9.s(0), new es());
    }

    @Override // com.larus.platform.api.m3
    public final AppImageUploadPerfOptConf getNewImageUploadPerfOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new bu9.w();
        return (AppImageUploadPerfOptConf) l0.a(bu9.w.a(), new cu());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.h0 getNewPreviewConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        int r2 = 0;
        du9.u1 r3 = (du9.u1) l0.a(new du9.u1(0), new vq());
        ECommerceSettingsConfig r4 = e10.S();
        du9.a0 r5 = r3.c();
        if (r5 == null) goto L5;
        boolean r6 = r5.d();
    L6:
        du9.a0 r7 = r3.c();
        if (r7 == null) goto L9;
        boolean r8 = r7.c();
    L10:
        du9.a0 r9 = r3.c();
        if (r9 == null) goto L13;
        boolean r10 = r9.b();
    L14:
        du9.a0 r11 = r3.c();
        if (r11 == null) goto L20;
        List r12 = r11.a();
        if (r12 == null) goto L20;
        List r13 = CollectionsKt.filterNotNull(r12);
        if (r13 == null) goto L20;
    L21:
        List r14 = r13;
        du9.a0 r15 = r3.c();
        if (r15 == null) goto L24;
        int r16 = r15.e();
    L25:
        boolean r17 = r4.getEnableFindSimilar();
        List r18 = r4.getFindSimilarActionBarInstructionTypeList();
        if (r18 == null) goto L29;
        List r19 = CollectionsKt.filterNotNull(r18);
        if (r19 == null) goto L29;
    L30:
        List r110 = r19;
        List r20 = r4.getFindSimilarLlmIntentionDetailList();
        if (r20 == null) goto L34;
        List r21 = CollectionsKt.filterNotNull(r20);
        if (r21 == null) goto L34;
    L35:
        com.larus.platform.model.chat.l r111 = new com.larus.platform.model.chat.l(r6, r8, r10, r14, r16, r17, r110, r21);
        du9.b0 r22 = r3.a();
        if (r22 == null) goto L38;
        boolean r23 = r22.a();
    L39:
        du9.b0 r24 = r3.a();
        if (r24 == null) goto L42;
        r2 = r24.b();
    L42:
        com.larus.platform.model.chat.m r25 = new com.larus.platform.model.chat.m(r23, r2);
        du9.z1 r26 = r3.b();
        if (r26 == null) goto L45;
        boolean r28 = r26.a();
    L47:
        return new com.larus.platform.model.chat.h0(r111, r25, new com.larus.platform.model.chat.k0(r28));
    L45:
        r28 = true;
        goto L47
    L38:
        r23 = false;
    L34:
        r21 = CollectionsKt.emptyList();
    L29:
        r19 = CollectionsKt.emptyList();
        goto L30
    L24:
        r16 = 0;
    L20:
        r13 = CollectionsKt.emptyList();
        goto L21
    L13:
        r10 = false;
        goto L14
    L9:
        r8 = false;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final ObricWindowMessageBubbleConfig getObricWindowMessageBubbleConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (ObricWindowMessageBubbleConfig) l0.a(new ObricWindowMessageBubbleConfig(false, null, null, 7, null), new vd());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.u3 getPicGroupStyleConfig() {
        e10 r0 = e10.a;
        return (hq9.u3) l0.a(new hq9.u3(0), new ip());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.l0 getPushMainBotOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.c2();
        return (com.larus.platform.model.chat.l0) l0.a(new com.larus.platform.model.chat.l0(0), new d10());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.w3 getReachConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.w3) l0.a(new hq9.w3(null), new qm());
    }

    @Override // com.larus.platform.api.m3
    public final x3 getRealCallSoundConfig() {
        e10 r0 = e10.a;
        qt9.l1 r1 = (qt9.l1) l0.a(new qt9.l1(0), new hf());
        return new x3(r1.d(), r1.b(), r1.a(), r1.c());
    }

    @Override // com.larus.platform.api.m3
    public final int getRealtimeCallCamera2Override() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(-1, new fh())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.u getRealtimeCallDowngradeConfig() {
        e10 r0 = e10.a;
        wv9.a r1 = (wv9.a) l0.a(new wv9.a(0), new ag());
        return new lq9.u(r1.a(), r1.b());
    }

    @Override // com.larus.platform.api.m3
    public final lq9.w getRealtimeCallNewStyleConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new wv9.e();
        return (lq9.w) l0.a(wv9.e.a(), new fp());
    }

    @Override // com.larus.platform.api.m3
    public final lq9.x getRealtimeCallPreloadConfig() {
        e10 r0 = e10.a;
        return (lq9.x) l0.a(new lq9.x(null), new com.larus.settings.value.l());
    }

    @Override // com.larus.platform.api.m3
    public final lq9.y getRealtimeCallTranslatorConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new wv9.f();
        return (lq9.y) l0.a(wv9.f.a(), new qg());
    }

    @Override // com.larus.platform.api.m3
    public final List<Integer> getRealtimeCameraRetryAllowErrorCodes() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new nw());
    }

    @Override // com.larus.platform.api.m3
    public final int getRedDotShowLimitDays() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new k8())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final List<Integer> getReportWhiteList() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new zm());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.b4 getResourceCenterConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.b4) l0.a(new hq9.b4(0), new e4());
    }

    @Override // com.larus.platform.api.m3
    public final f4 getRouterConfig() {
        e10 r0 = e10.a;
        qt9.z3 r1 = e10.m0();
        return new f4(r1.b(), r1.d(), r1.e(), r1.c(), r1.i(), r1.k(), r1.m(), r1.g(), r1.j(), r1.l(), r1.h(), r1.f(), r1.n(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.h4 getSaasShareConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new bw9.a();
        return (hq9.h4) l0.a(bw9.a.a(), new com.larus.settings.value.f4());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.m0 getSelectAutoRefConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new h2();
        return (com.larus.platform.model.chat.m0) l0.a(h2.a(), new am());
    }

    @Override // com.larus.platform.api.m3
    public final int getSelfMessageMenuStyle() {
        e10 r0 = e10.a;
        return ((du9.i2) l0.a(new du9.i2(0), new bu())).a();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.k4 getSendEntityConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return new hq9.k4(((SendEntityConfig) l0.a(new SendEntityConfig(null, 1, null), new ou())).getMaxParallelUploadEntityCount());
    }

    @Override // com.larus.platform.api.m3
    public final l4 getSendMessageNetworkToastConfig() {
        e10 r0 = e10.a;
        vu9.d r1 = (vu9.d) l0.a(new vu9.d(0), new oc());
        return new l4(r1.b(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.n0 getSendMsgPerfOptConfig() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.n0) l0.a(new com.larus.platform.model.chat.n0(0), new ck());
    }

    @Override // com.larus.platform.api.m3
    public final int getSessionMemoryDuration() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(20, new x00())).intValue();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, hq9.n4] */
    @Override // com.larus.platform.api.m3
    public final n4 getShareConfig() {
        Ref$ObjectRef r0 = new Ref$ObjectRef();
        r0.element = new n4(null);
        IFlowChatThemeConfigProvider r1 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r1 == null) goto L6;
        r1.d(new k2(r0), new l2(r0), AdaptThemeFeatureKey.CHAT_SHARE_CONFIG_CUSTOM_SETTING);
    L6:
        return (n4) r0.element;
    }

    @Override // com.larus.platform.api.m3
    public final boolean getShareUnifyOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ie())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.o4 getSidebarCaseConfig() {
        e10 r0 = e10.a;
        dw9.a r1 = (dw9.a) l0.a(new dw9.a(0), new dn());
        return new hq9.o4(r1.c(), r1.a(), r1.b(), r1.d());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.p4 getSlardarCrashNestedFileCmeConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new qt9.d4();
        return (hq9.p4) l0.a(new hq9.p4(0), new sh());
    }

    @Override // com.larus.platform.api.m3
    public final SlashMentionConfig getSlashMentionConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (SlashMentionConfig) l0.a(new SlashMentionConfig(false, false, false, null, null, 31, null), new com.larus.settings.value.c());
    }

    @Override // com.larus.platform.api.m3
    public final q4 getStreamAsrConfig() {
        e10 r0 = e10.a;
        return (q4) l0.a(new q4(0), new eo());
    }

    @Override // com.larus.platform.api.m3
    public final boolean getSubConversationNewOnboardingStyle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ba())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean getSubConversationNewShowSuggest() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new rv())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean getSubConversationNewSimplifySettings() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new d00())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean getSuggestPromptFoldCoCo() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new gv())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int getSuggestPromptFoldType() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0, new ct())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final ToastRequestDowngradeConfig getToastRequestDowngradeConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (ToastRequestDowngradeConfig) l0.a(new ToastRequestDowngradeConfig(null, 1, null), new i7());
    }

    @Override // com.larus.platform.api.m3
    public final int getTtsBackgroundPlayExperimentMode() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(-1, new zp())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.u4 getUgcMarkdownStyleConfig() {
        e10 r0 = e10.a;
        return (hq9.u4) l0.a(new hq9.u4(0), new jy());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.v4 getUgcTimeStampConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.v4) l0.a(new hq9.v4(0), new rx());
    }

    @Override // com.larus.platform.api.m3
    public final mq9.l getUserAvatarAuthStyleConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new wt9.e();
        return (mq9.l) l0.a(wt9.e.a(), new h9());
    }

    @Override // com.larus.platform.api.m3
    public final z4 getVibrateConfig() {
        e10 r1 = e10.a;
        return new z4(((iw9.a) l0.a(new iw9.a(0), new rj())).b(), ((iw9.a) l0.a(new iw9.a(0), new rj())).a());
    }

    @Override // com.larus.platform.api.m3
    public final String getVideoCreationFallbackAnchorName() {
        e10 r0 = e10.a;
        return (String) l0.a("anchor_name_default_video", new og());
    }

    @Override // com.larus.platform.api.m3
    public final nr9.h getVideoStyleAnimConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (nr9.h) l0.a(new nr9.h(0), new com.larus.settings.value.f1());
    }

    @Override // com.larus.platform.api.m3
    public final String getVoiceCallAbServerTestDid() {
        e10 r0 = e10.a;
        return (String) l0.a("default", new kr());
    }

    @Override // com.larus.platform.api.m3
    public final String getVoiceCallAbServerTestUid() {
        e10 r0 = e10.a;
        return (String) l0.a("default", new dh());
    }

    @Override // com.larus.platform.api.m3
    public final String getVoiceCallAbTestDid() {
        e10 r0 = e10.a;
        return (String) l0.a("default", new cb());
    }

    @Override // com.larus.platform.api.m3
    public final String getVoiceCallAbTestUid() {
        e10 r0 = e10.a;
        return (String) l0.a("default", new t7());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.c5 getVoiceCallEntranceConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.c5) l0.a(new hq9.c5(null), new du());
    }

    @Override // com.larus.platform.api.m3
    public final int getVoiceEditPanelExpandByDefault() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1, new my())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final int getVoiceMixInputScene() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1, new m2())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final d5 getVoiceSettingConvenienceConfig() {
        e10 r0 = e10.a;
        return (d5) l0.a(new d5(false, false, false), new li());
    }

    @Override // com.larus.platform.api.m3
    public final long getWatermarkPollInterval() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(1000L, new ae())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final int getWatermarkPollMaxCount() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(5, new sa())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final int getWcbMinConsumedDurationSec() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(600, new bx())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.f5 getWechatLoginConfig() {
        e10 r0 = e10.a;
        av9.h r1 = e10.y0();
        return new hq9.f5(r1.a(), r1.b(), r1.c());
    }

    @Override // com.larus.platform.api.m3
    public final boolean getZMainInputBoxShow() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new c8())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean h0() {
        e10 r0 = e10.a;
        return e10.y().a();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.w0 h1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        du9.e0 r2 = (du9.e0) l0.a(new du9.e0(), new ea());
        return new hq9.w0(r2.a(), r2.b());
    }

    @Override // com.larus.platform.api.m3
    public final boolean h2() {
        e10 r0 = e10.a;
        return e10.G0().getEnableTask();
    }

    @Override // com.larus.platform.api.m3
    public final boolean h3() {
        e10 r0 = e10.a;
        return e10.h();
    }

    @Override // com.larus.platform.api.m3
    public final boolean hasAvatarModelUpdate() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new kc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean hasFaceMemoryFunc() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new mr())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean hideAudioVoiceSettingsName() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new lr())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final long hideWcbBeforeTimestamp() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(0L, new yu())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean i() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new vw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean i0() {
        e10 r0 = e10.a;
        Boolean r1 = e10.z().j();
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean i1() {
        e10 r0 = e10.a;
        return !Intrinsics.areEqual(e10.z().h(), Boolean.FALSE);
    }

    @Override // com.larus.platform.api.m3
    public final hq9.x2 i3() {
        k.a.getClass();
        return k.l;
    }

    @Override // com.larus.platform.api.m3
    public final t1 imageGenerateHeicConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return new t1(((du9.w0) l0.a(new du9.w0(), new n7())).a());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.w1 imageUploadOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        ImageUploadOptConfig r2 = (ImageUploadOptConfig) l0.a(new ImageUploadOptConfig(0, 0, 0, 0, 15, null), new a4());
        return new hq9.w1(r2.getAlbumResize(), r2.getAlbumQuality(), r2.getCameraResize(), r2.getCameraQuality());
    }

    @Override // com.larus.platform.api.m3
    public final boolean immerseBgDynamicEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.y3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final InputComponentConfig inputComponentConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new xu9.a();
        return (InputComponentConfig) l0.a(xu9.a.a(), new f6());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.x1 inputEnhance() {
        e10 r0 = e10.a;
        return new hq9.x1(((du9.z0) l0.a(new du9.z0(0), new jd())).a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean inputMarginWithKeyboardOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.n0())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isAccessibilitySdkInitEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new wg())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isAutoSayHelloInCallBot() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new d6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isBotProfileShowLLMDisclaimerPoweredHint() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new d7())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isCameraAlbumMultiSelectEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ki())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isCommentRemoveInitLoadingDelay() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new qd())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isDisableLatex() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new sx())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isDoraAudioControlEnabled() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new th())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isDoraSummaryQuicEnabled() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new wh())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isFixSamiRequestNoDid() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.o2())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isLazyMainComponentEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new mj())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isMarkdownStreamOptimized() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new uy())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isOfficeDocNewConversationEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new f9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isPinEncryptionDiscontinue() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.z4())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isRealtimeCameraOpenAsyncEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new wu())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isRealtimeCameraOpenDeduplicationEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new gu())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isRealtimeCameraRetryEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new wc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isRealtimeVeCameraEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new g6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isRealtimeVeSdkPreInitEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new aw())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isRealtimeVideoBackgroundPublishEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new of())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isSubConvCreateOptEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.n4())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isThreadSleepBugFixEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new dc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean isTimonClipboardEnabled() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new io())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean j() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.j();
    }

    @Override // com.larus.platform.api.m3
    public final boolean j0() {
        e10 r0 = e10.a;
        return e10.n0().i();
    }

    @Override // com.larus.platform.api.m3
    public final boolean j1() {
        e10 r0 = e10.a;
        return ((hu9.x) l0.a(new hu9.x(0), new s0())).a();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.p1 j2() {
        e10 r0 = e10.a;
        HealthFirstPartyApplicationConfig r1 = e10.X();
        List r2 = r1.getHealthBotList();
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        String r3 = r1.getSettingAgreementTitle();
        String r4 = XmlPullParser.NO_NAMESPACE;
        if (r3 != null) goto L8;
        r3 = XmlPullParser.NO_NAMESPACE;
    L8:
        String r5 = r1.getSettingAgreementUrl();
        if (r5 != null) goto L11;
        r5 = XmlPullParser.NO_NAMESPACE;
    L11:
        String r6 = r1.getSettingAgreementTrackName();
        if (r6 == null) goto L16;
        r4 = r6;
    L16:
        return new hq9.p1(r2, r3, r5, r4);
    }

    @Override // com.larus.platform.api.m3
    public final List<hq9.d> k0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        List r2 = (List) l0.a(CollectionsKt.emptyList(), new ns());
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ActionConfig r5 = (ActionConfig) r4.next();
        hq9.d r6 = new hq9.d(0);
        r6.a = r5.getIconName();
        r6.b = r5.getDarkIconName();
        r6.c = r5.getSchema();
        r6.d = r5.getBackgroundColor();
        r6.e = r5.getTitle();
        r3.add(r6);
        goto L4
    L6:
        return r3;
    }

    @Override // com.larus.platform.api.m3
    public final boolean k1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new tf())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.x0 k2() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.x0) l0.a(new com.larus.platform.model.chat.x0(0), new com.larus.settings.value.x2());
    }

    @Override // com.larus.platform.api.m3
    public final boolean k3() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new m2())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.z1 kevaAnrOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (hq9.z1) l0.a(new hq9.z1(null), new go());
    }

    @Override // com.larus.platform.api.m3
    public final KmpInstructionCoreOptConfig kmpInstructionCoreOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (KmpInstructionCoreOptConfig) l0.a(new KmpInstructionCoreOptConfig(false, null, 3, null), new com.larus.settings.value.p());
    }

    @Override // com.larus.platform.api.m3
    public final boolean l() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.l();
    }

    @Override // com.larus.platform.api.m3
    public final boolean l0() {
        e10 r0 = e10.a;
        return e10.n0().l();
    }

    @Override // com.larus.platform.api.m3
    public final boolean l1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new wt9.b();
        return ((mq9.b) l0.a(new mq9.b(0), new lb())).a();
    }

    @Override // com.larus.platform.api.m3
    public final RealtimeCallHelloConfig l2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (RealtimeCallHelloConfig) l0.a(new RealtimeCallHelloConfig(null, false, 3, null), new he());
    }

    @Override // com.larus.platform.api.m3
    public final String l3() {
        e10 r0 = e10.a;
        String r1 = e10.n0().d();
        if (r1 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r1;
    }

    @Override // com.larus.platform.api.m3
    public final List<String> larkAuthInjectHostList() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new w7());
    }

    @Override // com.larus.platform.api.m3
    public final LarkMinutesRecordingConfig larkMinutesRecordingConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (LarkMinutesRecordingConfig) l0.a(new LarkMinutesRecordingConfig(0, 0, false, 7, null), new xv());
    }

    @Override // com.larus.platform.api.m3
    public final boolean larkScanCodeLoginEnabled() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new xa())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.z latestPhotoShortcutConfig() {
        e10 r0 = e10.a;
        du9.e1 r1 = (du9.e1) l0.a(new du9.e1(0), new mf());
        return new com.larus.platform.model.chat.z(r1.b(), r1.f(), r1.c(), r1.e(), r1.d(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean longPressShowMultiSelect() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ra())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int m1() {
        e10 r0 = e10.a;
        return e10.J0().a();
    }

    @Override // com.larus.platform.api.m3
    public final boolean m3() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean manualInterruptEnableRTCAec() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.r2())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean markSelectModeEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new oa())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.a0 messageBlockConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (com.larus.platform.model.chat.a0) l0.a(new com.larus.platform.model.chat.a0(0), new com.larus.settings.value.j0());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.b0 messageInputMenuConfig() {
        e10 r0 = e10.a;
        j1 r1 = (j1) l0.a(new j1(0), new gd());
        return new com.larus.platform.model.chat.b0(r1.c(), r1.b(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.f0 messageModifyConfig() {
        e10 r0 = e10.a;
        du9.o1 r1 = (du9.o1) l0.a(new du9.o1(0), new hj());
        MessageModifyStyle.a r2 = MessageModifyStyle.Companion;
        int r3 = r1.c();
        r2.getClass();
        if (r3 != 1) goto L5;
        MessageModifyStyle r4 = MessageModifyStyle.FULL_BOX;
    L7:
        return new com.larus.platform.model.chat.f0(r4, r1.a(), r1.b());
    L5:
        r4 = MessageModifyStyle.SMALL_BOX;
        goto L7
    }

    @Override // com.larus.platform.api.m3
    public final int messageRegenMaxCount() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(10, new j00())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean messageVoicePlay() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ye())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final MultiBotsStatusUIFixConfig multiBotsStatusUIFixConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (MultiBotsStatusUIFixConfig) l0.a(new MultiBotsStatusUIFixConfig(null, null, 3, null), new ej());
    }

    @Override // com.larus.platform.api.m3
    public final String musicCreateStreamingHost() {
        e10 r0 = e10.a;
        return (String) l0.a(XmlPullParser.NO_NAMESPACE, new v5());
    }

    @Override // com.larus.platform.api.m3
    public final boolean musicCreateSupportCoverEdit() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new hi())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean musicCreateSupportDetail() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new oz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean musicCreateSupportStreaming() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new a3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.j n() {
        e10 r0 = e10.a;
        pt9.e r1 = e10.x();
        return new hq9.j(r1.a(), r1.e(), r1.c(), r1.g(), r1.b(), r1.f(), r1.d(), r1.i(), r1.h());
    }

    @Override // com.larus.platform.api.m3
    public final kq9.p n1() {
        e10 r0 = e10.a;
        gt9.d r1 = (gt9.d) l0.a(new gt9.d(0), new lq());
        return new kq9.p(r1.b(), r1.c(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean n2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ng())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final long n3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(200L, new ln())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.m3 networkAutoSwitch() {
        e10 r0 = e10.a;
        qt9.j3 r1 = (qt9.j3) l0.a(new qt9.j3(0), new i5());
        return new hq9.m3(r1.b(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean o() {
        e10 r0 = e10.a;
        return com.larus.utils.o0.d(e10.o0().b());
    }

    @Override // com.larus.platform.api.m3
    public final hq9.i0 o0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        du9.s r2 = (du9.s) l0.a(new du9.s(), new dp());
        if (r2.b() == true) goto L5;
    L7:
        boolean r3 = false;
    L9:
        return new hq9.i0(r3, r2.c(), r2.a());
    L5:
        if (IMinorService.a.a() == true) goto L7;
        r3 = true;
        goto L9
    }

    @Override // com.larus.platform.api.m3
    public final List<Integer> o1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.listOf(new Integer[]{1, 3, 4, 6, 9, 10, 11}), new u00());
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.f o2() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.f) l0.a(new com.larus.platform.model.chat.f(0), new com.larus.settings.value.i3());
    }

    @Override // com.larus.platform.api.m3
    public final lq9.f0 o3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        int r2 = 0;
        vt9.x0 r3 = (vt9.x0) l0.a(new vt9.x0(0), new oq());
        Boolean r4 = r3.a();
        if (r4 == null) goto L5;
        boolean r5 = r4.booleanValue();
    L6:
        Integer r6 = r3.b();
        if (r6 == null) goto L9;
        r2 = r6.intValue();
    L9:
        Boolean r7 = r3.d();
        if (r7 == null) goto L12;
        r7.booleanValue();
    L12:
        List r8 = r3.c();
        if (r8 == null) goto L16;
        List r9 = CollectionsKt.filterNotNull(r8);
        if (r9 == null) goto L16;
    L18:
        return new lq9.f0(r5, r2, r9);
    L16:
        r9 = CollectionsKt.emptyList();
        goto L18
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final List<String> officeDocShareHorizontalItems() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(cr9.c.a, new ap());
    }

    @Override // com.larus.platform.api.m3
    public final OfficeRecordingAIInterpreterConfig officeRecordingAIInterpreterConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (OfficeRecordingAIInterpreterConfig) l0.a(new OfficeRecordingAIInterpreterConfig(false, false, 3, null), new pj());
    }

    @Override // com.larus.platform.api.m3
    public final String officeUrlPreviewBaseUrl() {
        e10 r0 = e10.a;
        return (String) l0.a("https://www.feishu.cn", new td());
    }

    @Override // com.larus.platform.api.m3
    public final long openTraceExecuteThreshold() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(100L, new i00())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean optDialogDismiss() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new mp())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean optPasteFile() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new fe())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean optPushAnr() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.u1())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean optRedundantDecoderInVideoCall() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new lu())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean optRequestMyUgcVoiceList() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ze())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean optimizeMarkdownListParse() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new yb())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean optimizeMessageListPrepend() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new kx())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean optimizeMessageListPrependHotLaunch() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new iy())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int p() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(Integer.valueOf(EventsUtils.FEAT_TYPE_SHUT_DOWN), new com.larus.settings.value.b0())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final AudioHostConfig p1() {
        return new AudioHostConfig(lq9.d.a(), null, 2, null);
    }

    @Override // com.larus.platform.api.m3
    public final int positiveMsgSplitTimeInterval() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(60, new x9())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean preferBottomOverlaySheetTapTarget() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ib())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final kq9.t preprocessAlbumImgOptConfig() {
        e10 r0 = e10.a;
        return (kq9.t) l0.a(new kq9.t(0), new com.larus.settings.value.l1());
    }

    @Override // com.larus.platform.api.m3
    public final ProfileLikeCollectListConfig profileLikeCollectListConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (ProfileLikeCollectListConfig) l0.a(new ProfileLikeCollectListConfig(0, 1, null), new bo());
    }

    @Override // com.larus.platform.api.m3
    public final int promptCacheMaxSize() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(30, new p6())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean pushHotShowQuestion() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new zu())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.m4 q() {
        return new hq9.m4(null);
    }

    @Override // com.larus.platform.api.m3
    public final boolean q0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new tl())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final n2 q1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (n2) l0.a(new n2(0), new ud());
    }

    @Override // com.larus.platform.api.m3
    public final boolean q3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new bp())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final HoverActionConfig r() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        QuoteReplyConfig.Companion.getClass();
        QuoteReplyConfig r2 = (QuoteReplyConfig) l0.a(QuoteReplyConfig.access$getDEFAULT$cp(), new hp());
        HoverActionConfig.a r3 = HoverActionConfig.Companion;
        int r4 = r2.getGroup();
        boolean r8 = r2.getSupportMainBot();
        boolean r9 = r2.getSupportOfficialBot();
        boolean r10 = r2.getSupportUserBot();
        r3.getClass();
        if (r4 != 1) goto L5;
        HoverActionConfig r5 = HoverActionConfig.access$getGROUP_V1$cp();
    L16:
        return HoverActionConfig.copy$default(r5, false, false, false, false, r8, r9, r10, 15, null);
    L5:
        if (r4 != 2) goto L7;
        r5 = HoverActionConfig.access$getGROUP_V2$cp();
        goto L16
    L7:
        if (r4 != 3) goto L9;
        r5 = HoverActionConfig.access$getGROUP_V3$cp();
        goto L16
    L9:
        if (r4 == 4) goto L11;
        r5 = HoverActionConfig.access$getGROUP_CONTROL$cp();
        goto L16
    L11:
        r5 = HoverActionConfig.access$getGROUP_V4$cp();
        goto L16
    }

    @Override // com.larus.platform.api.m3
    public final boolean r0() {
        e10 r0 = e10.a;
        return e10.G0().getEnableInterceptor();
    }

    @Override // com.larus.platform.api.m3
    public final boolean r1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new du9.a();
        return ((AIFloatChatConfig) l0.a(new AIFloatChatConfig(false, false, 3, null), new r5())).getNavigationBarEnabled();
    }

    @Override // com.larus.platform.api.m3
    public final boolean r3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new xd())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean realtimeCallAllSceneMixEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.k3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean realtimeCallAutoInterrupt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new uc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean realtimeCallImageTriggerFix() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new u2())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.v realtimeCallLanguageConfig() {
        e10 r0 = e10.a;
        return (lq9.v) l0.a(new lq9.v(null), new rb());
    }

    @Override // com.larus.platform.api.m3
    public final RealtimeCallSceneConfig realtimeCallSceneConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        RealtimeCallSceneConfig.Companion.getClass();
        return (RealtimeCallSceneConfig) l0.a(RealtimeCallSceneConfig.access$getDEFAULT$cp(), new qh());
    }

    @Override // com.larus.platform.api.m3
    public final HashMap<String, List<Integer>> realtimeCallServerLimitErrorInfo() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (HashMap) l0.a(new HashMap(), new ik());
    }

    @Override // com.larus.platform.api.m3
    public final int realtimeCallSwitchMicForPseudoConnectInterval() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(3000, new s00())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean realtimeCallUseEndCallBgModeSnapshot() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new iz())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean realtimeCallUseTwoLineStyle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new s8())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean realtimeCallUseUplinkHangUp() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new u9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.z realtimeClientRetryConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (lq9.z) l0.a(new lq9.z(null), new com.larus.settings.value.j1());
    }

    @Override // com.larus.platform.api.m3
    public final boolean realtimeFixRTCNoticePauseEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new g00())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int realtimeMaxAliveDuration() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(5400, new ch())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean realtimeSceneMixEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new zg())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.e0 realtimeScreenShareEncoderConfig() {
        e10 r0 = e10.a;
        return (lq9.e0) l0.a(new lq9.e0(0), new we());
    }

    @Override // com.larus.platform.api.m3
    public final RealtimeSuggestUIConfig realtimeSuggestUIConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        RealtimeSuggestUIConfig.Companion.getClass();
        return (RealtimeSuggestUIConfig) l0.a(RealtimeSuggestUIConfig.access$getDEFAULT$cp(), new xb());
    }

    @Override // com.larus.platform.api.m3
    public final boolean realtimeTalkbackOptEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.valueOf(!AppHost.a.isOversea()), new l6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.a0 realtimeVLMOfficialConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (lq9.a0) l0.a(new lq9.a0(0), new e5());
    }

    @Override // com.larus.platform.api.m3
    public final lq9.b0 realtimeVLMOfficialNoticeConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (lq9.b0) l0.a(new lq9.b0(0), new im());
    }

    @Override // com.larus.platform.api.m3
    public final RecordingPersonalNotesConfig recordingPersonalNotesConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (RecordingPersonalNotesConfig) l0.a(new RecordingPersonalNotesConfig(false, 1, null), new qi());
    }

    @Override // com.larus.platform.api.m3
    public final boolean rememberCameraPositionEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new eg())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.a4 renderFreezeOptConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new ot9.t();
        ot9.s r2 = (ot9.s) l0.a(ot9.t.a(), new ui());
        return new hq9.a4(r2.b(), r2.c(), r2.a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean reverseEnterImageDetailOpt() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new pv())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean s() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.s();
    }

    @Override // com.larus.platform.api.m3
    public final boolean s1() {
        e10 r0 = e10.a;
        Boolean r1 = e10.z().b();
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean s2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ut())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final Pair<Boolean, Long> s3() {
        return TuplesKt.to(Boolean.FALSE, 0L);
    }

    @Override // com.larus.platform.api.m3
    public final int samiConnectTimeout() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(10000, new kj())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.c0 samiEventBlockConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (lq9.c0) l0.a(new lq9.c0(null), new el());
    }

    @Override // com.larus.platform.api.m3
    public final boolean searchForceByLike() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new hq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean sendMsgShowAiBeautifyBtn() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.d())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean setupPreInstallChannels() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.n2())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean shareQrCodeUseCustomStyle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new fm())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean shareScreenEnableDualAec() {
        e10 r0 = e10.a;
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new wb())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean shareScreenUseSoftAec() {
        e10 r0 = e10.a;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 29) goto L5;
        boolean r3 = false;
    L6:
        if (r3 == true) goto L11;
        if (r1 >= 29) goto L9;
        boolean r2 = false;
    L10:
        if (r2 == true) goto L11;
        return false;
    L9:
        int r4 = l0.a;
        r2 = ((Boolean) l0.a(Boolean.FALSE, new wb())).booleanValue();
    L11:
        return true;
    L5:
        int r5 = l0.a;
        r3 = ((Boolean) l0.a(Boolean.FALSE, new hu())).booleanValue();
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final boolean showDisclaimer() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new lk())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean showNetworkStatusInTitle() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new av())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean showNewTopicMainBotEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new r4())).booleanValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (AppHost.a.isOversea() == true) goto L7;
    L8:
        return true;
    L7:
        if (ILoginService.a.getAccountInfo().a == false) goto L9;
        goto L8
    }

    @Override // com.larus.platform.api.m3
    public final boolean showPodcastsTopBanner() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new ju())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final long showWCBMinIntervalBeforePrevMessage() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(60L, new ev())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean skipUpdateIndexWhenLoading() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new pu())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final String speechAecForceMicSelect() {
        e10 r0 = e10.a;
        return (String) l0.a(XmlPullParser.NO_NAMESPACE, new lx());
    }

    @Override // com.larus.platform.api.m3
    public final boolean startTtsWhenReceiveContent() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new nn())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean streamPlayerUseMediaSession() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new po())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.q0 subConvKeyboardConfig() {
        e10 r0 = e10.a;
        du9.n2 r1 = (du9.n2) l0.a(new du9.n2(0), new hl());
        return new com.larus.platform.model.chat.q0(r1.b(), r1.a());
    }

    @Override // com.larus.platform.api.m3
    public final int subMessageAutoRequestNum() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(6, new qv())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean supportLarusThemeTag() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new tc())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean switchReadyToSpeakOnHideIme() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new tv())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final nr9.b t() {
        e10 r0 = e10.a;
        qt9.s1 r1 = (qt9.s1) l0.a(new qt9.s1(0), new br());
        return new nr9.b(r1.a(), r1.b());
    }

    @Override // com.larus.platform.api.m3
    public final List<String> t0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new rs());
    }

    @Override // com.larus.platform.api.m3
    public final boolean t2() {
        e10 r0 = e10.a;
        return e10.n0().o();
    }

    @Override // com.larus.platform.api.m3
    public final boolean t3() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((DoraDiaryConfig) l0.a(new DoraDiaryConfig(false, 0, 3, null), new bn())).getTopbarShowEnvAuth();
    }

    @Override // com.larus.platform.api.m3
    public final int ttsMaxCacheCount() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(10, new uh())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final lq9.j0 ttsSwitchConfig() {
        e10 r0 = e10.a;
        return (lq9.j0) l0.a(new lq9.j0(0), new c6());
    }

    @Override // com.larus.platform.api.m3
    public final lq9.k0 ttsSwitchLongPressConfig() {
        e10 r0 = e10.a;
        return (lq9.k0) l0.a(new lq9.k0(0), new m6());
    }

    @Override // com.larus.platform.api.m3
    public final boolean ttsUseGainTransientFocusType() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new hn())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean ttsUseLocalStatus() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new com.larus.settings.value.d5())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.o0 u0() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.o0) l0.a(new com.larus.platform.model.chat.o0(0), new ko());
    }

    @Override // com.larus.platform.api.m3
    public final boolean u1() {
        e10 r0 = e10.a;
        return e10.n0().j();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.t4 ugReturnConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        qt9.q4 r2 = (qt9.q4) l0.a(new qt9.q4(0), new ig());
        boolean r3 = r2.a();
        Map r4 = r2.b();
        if (r4 != null) goto L6;
        r4 = MapsKt.emptyMap();
    L6:
        return new hq9.t4(r3, r4);
    }

    @Override // com.larus.platform.api.m3
    public final VoiceRecommendConfig ugcVoiceRecommend() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (VoiceRecommendConfig) l0.a(new VoiceRecommendConfig(false, false, 3, null), new nl());
    }

    @Override // com.larus.platform.api.m3
    public final boolean updateNetInfoAndSubtitleStatusEnabled() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new m5())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean uploaderUseCachedTokenEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new r3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean useDuplexStateForCallConsumer() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new zq())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean useNewAecProcessor() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new i6())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean useOldVoiceInputIcon() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new m7())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean usePreCreateWebView() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new lv())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean useSafeAudioTrackEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new b10())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final int useVoiceToCompleteTimeout() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(600, new kv())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.x4 userAvatarImgConfig() {
        e10 r0 = e10.a;
        return new hq9.x4(((wt9.g) l0.a(new wt9.g(0), new w8())).a());
    }

    @Override // com.larus.platform.api.m3
    public final boolean v() {
        e10 r0 = e10.a;
        return e10.v0().getHoverEveryPrompt();
    }

    @Override // com.larus.platform.api.m3
    public final boolean v0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new c9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final List<String> v1() {
        e10 r0 = e10.a;
        return e10.c0();
    }

    @Override // com.larus.platform.api.m3
    public final kq9.q v2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        int r2 = 0;
        gt9.f r3 = (gt9.f) l0.a(new gt9.f(0), new gc());
        int r4 = r3.b();
        boolean r5 = r3.c();
        gt9.c r6 = r3.a();
        if (r6 == null) goto L5;
        int r7 = r6.a();
    L6:
        gt9.c r8 = r3.a();
        if (r8 == null) goto L9;
        int r9 = r8.c();
    L10:
        gt9.c r10 = r3.a();
        if (r10 == null) goto L14;
        r2 = r10.b();
    L14:
        return new kq9.q(r5, r4, new kq9.o(r7, r9, r2));
    L9:
        r9 = FastSendFromShowType.EVERY_COLD_LAUNCH.getType();
        goto L10
    L5:
        r7 = FastSendFromCameraScene.DEFAULT.getScene();
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final hq9.z3 v3() {
        e10 r0 = e10.a;
        return (hq9.z3) l0.a(new hq9.z3(0), new com.larus.settings.value.e());
    }

    @Override // com.larus.platform.api.m3
    public final String videoGenerateShareHost() {
        e10 r0 = e10.a;
        return (String) l0.a(XmlPullParser.NO_NAMESPACE, new com.larus.settings.value.b2());
    }

    @Override // com.larus.platform.api.m3
    public final boolean voiceGlobalSwitchEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.w0())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean voiceInputDirectFillInput() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new zb())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final HandsfreeExperimentConfig voiceInputHandsfreeConfig() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (HandsfreeExperimentConfig) l0.a(new HandsfreeExperimentConfig(0, null, false, false, 0, 0, false, false, 255, null), new no());
    }

    @Override // com.larus.platform.api.m3
    public final boolean voiceItemCreatorEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.j3())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean voiceItemHotEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new p9())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final boolean voiceMultiTabEnable() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new t8())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.o1 w() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        du9.t0 r2 = (du9.t0) l0.a(new du9.t0(), new q00());
        return new hq9.o1(r2.a(), r2.d(), r2.c(), r2.b());
    }

    @Override // com.larus.platform.api.m3
    public final boolean w0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        if (((Number) l0.a(0, new ue())).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final String w1() {
        String r0 = com.larus.setting.api.u.a;
        return com.larus.setting.api.u.e;
    }

    @Override // com.larus.platform.api.m3
    public final int w2() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(-1, new rc())).intValue();
    }

    @Override // com.larus.platform.api.m3
    public final kq9.u watermarkRemovalConfig() {
        e10 r0 = e10.a;
        return (kq9.u) l0.a(new kq9.u(0), new j7());
    }

    @Override // com.larus.platform.api.m3
    public final boolean webviewAddThemeQuery() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new com.larus.settings.value.h4())).booleanValue();
    }

    @Override // com.larus.platform.api.m3
    public final String x() {
        e10 r0 = e10.a;
        return (String) l0.a(XmlPullParser.NO_NAMESPACE, new t5());
    }

    @Override // com.larus.platform.api.m3
    public final boolean x0() {
        e10 r0 = e10.a;
        return ((c) l0.a(new c(0), new yy())).b();
    }

    @Override // com.larus.platform.api.m3
    public final int x1() {
        e10 r0 = e10.a;
        return ((hu9.q) l0.a(new hu9.q(0), new bv())).a();
    }

    @Override // com.larus.platform.api.m3
    public final boolean x2() {
        e10 r0 = e10.a;
        vt9.f r1 = e10.z().o();
        if (r1 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r1.c(), Boolean.TRUE);
    }

    @Override // com.larus.platform.api.m3
    public final MultiBotsCapability x3() {
        e10 r0 = e10.a;
        return e10.H0();
    }

    @Override // com.larus.platform.api.m3
    public final JSONObject y() {
        int r0 = com.larus.settings.btm.a.a;
        JSONObject r1 = IBtmSettings.Companion.getBtmSdkConfig();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new JSONObject();
    }

    @Override // com.larus.platform.api.m3
    public final boolean y1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((qt9.a0) l0.a(new qt9.a0(), new jz())).canvasSSEKMPEnable;
    }

    @Override // com.larus.platform.api.m3
    public final int y2() {
        e10 r0 = e10.a;
        return e10.J0().d();
    }

    @Override // com.larus.platform.api.m3
    public final boolean y3() {
        e10 r0 = e10.a;
        return e10.I().k();
    }

    @Override // com.larus.platform.api.m3
    public final boolean z() {
        e10 r0 = e10.a;
        return e10.u0().b();
    }

    @Override // com.larus.platform.api.m3
    public final MarkDownSelectorSettings z1() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (MarkDownSelectorSettings) l0.a(new MarkDownSelectorSettings(0, 0, 0, 0, false, 31, null), new s9());
    }

    @Override // com.larus.platform.api.m3
    public final lq9.a z2() {
        e10 r0 = e10.a;
        return (lq9.a) e10.d.getValue();
    }

    @Override // com.larus.platform.api.m3
    public final com.larus.platform.model.chat.p0 z3() {
        e10 r0 = e10.a;
        return (com.larus.platform.model.chat.p0) l0.a(new com.larus.platform.model.chat.p0(0), new yc());
    }

    @Override // com.larus.platform.api.m3
    public final long zlinkStartDelayCheckTimeMills() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Number) l0.a(3000L, new com.larus.settings.value.d0())).longValue();
    }

    @Override // com.larus.platform.api.m3
    public final hq9.i1 B2() {
        com.larus.settings.ivy.webView.b r0 = com.larus.settings.ivy.webView.c.a();
        boolean r2 = r0.b();
        List r3 = r0.a();
        if (r3 == null) goto L5;
        List r4 = CollectionsKt.filterNotNull(r3);
    L7:
        return new hq9.i1(r2, r4, r0.c());
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.larus.platform.api.m3
    public final boolean D2() {
        if (m3() == false) goto L9;
        e10 r0 = e10.a;
        int r1 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new z8())).booleanValue() == false) goto L9;
        if (FeatureKitDelegate.b.l0().b() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final boolean J0() {
        return e.a().c();
    }

    @Override // com.larus.platform.api.m3
    public final h5 P() {
        com.larus.settings.ivy.a r0 = e.a();
        boolean r2 = r0.e();
        List r1 = r0.b();
        if (r1 != null) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        return new h5(r2, CollectionsKt.distinct(CollectionsKt.plus(CollectionsKt.filterNotNull(r1), e.b)), CollectionsKt.emptyList());
    }

    @Override // com.larus.platform.api.m3
    public final List<String> f3() {
        List r0 = e.a().f();
        if (r0 == null) goto L7;
        List<String> r1 = CollectionsKt.filterNotNull(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    @Override // com.larus.platform.api.m3
    public final boolean g() {
        if (m3() == false) goto L16;
        e10 r0 = e10.a;
        if (e10.E0() == false) goto L17;
        wv9.a r1 = (wv9.a) l0.a(new wv9.a(0), new ag());
        if (r1.b() == true) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (r1.a() == false) goto L12;
        r2 = false;
        goto L13
    L17:
        return false;
    L16:
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final List<String> g0() {
        List r0 = e.a().a();
        if (r0 == null) goto L5;
        List<String> r1 = CollectionsKt.filterNotNull(r0);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.platform.api.m3
    public final boolean j3() {
        return e.a().d();
    }

    @Override // com.larus.platform.api.m3
    public final boolean m2() {
        if (d2() == false) goto L10;
        e10 r0 = e10.a;
        Boolean r1 = e10.v().b();
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        if (r2 == false) goto L10;
        return true;
    L7:
        r2 = true;
    L10:
        return false;
    }

    @Override // com.larus.platform.api.m3
    public final boolean p2() {
        return enablePreloadChatPageView().b();
    }

    @Override // com.larus.platform.api.m3
    public final boolean ugcPreviewUseARGB() {
        com.larus.platform.model.chat.n r0 = getCreationPreviewPerformanceOptConfig();
        e10 r1 = e10.a;
        int r2 = l0.a;
        Boolean r3 = Boolean.FALSE;
        if (((Boolean) l0.a(r3, new wl())).booleanValue() == false) goto L5;
    L10:
        return true;
    L5:
        if (r0.a == true) goto L7;
    L9:
        return false;
    L7:
        if (((Boolean) l0.a(r3, new e7())).booleanValue() == false) goto L9;
        goto L9
    }

    @Override // com.larus.platform.api.m3
    public final Object P1(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        k r2 = k.a;     // Catch: Throwable -> L9
        Application r3 = AppHost.a.getApplication();     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        JSONObject r5 = k.c(r3);     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        Object r6 = p2.a(r4, r5);     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.m49constructorimpl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.m55isFailureimpl(r7) == true) goto L15;
        r0 = r7;
    L15:
        if (r0 == null) goto L18;
        return r0;
    L18:
        return p2.a(r4, IAbTest.a.s());
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.larus.platform.api.m3
    public final boolean a4(List<Block> r2) {
        Intrinsics.checkNotNullParameter(r2, "blockList");
        return true;
    }

    @Override // com.larus.platform.api.m3
    public final Boolean getSAMICoreAbBoolConfig(String r4) {
        Boolean r0 = Boolean.FALSE;
        AppHost.Companion r1 = AppHost.a;     // Catch: Exception -> L9
        Boolean r2 = (Boolean) SettingsManager.obtainSettingsFast(r1.getApplication()).getAppSettings().get(r4);     // Catch: Exception -> L9
        j37.a.b(r1.getApplication()).e(r4);     // Catch: Exception -> L6
        return r2;
    L6:
        r0 = r2;
    L8:
        return r0;
    }

    @Override // com.larus.platform.api.m3
    public final Float getSAMICoreAbFloatConfig(String r4) {
        Float r0 = Float.valueOf(0.0f);
        AppHost.Companion r1 = AppHost.a;     // Catch: Exception -> L9
        Float r2 = (Float) SettingsManager.obtainSettingsFast(r1.getApplication()).getAppSettings().get(r4);     // Catch: Exception -> L9
        j37.a.b(r1.getApplication()).e(r4);     // Catch: Exception -> L6
        return r2;
    L6:
        r0 = r2;
    L8:
        return r0;
    }

    @Override // com.larus.platform.api.m3
    public final Integer getSAMICoreAbIntConfig(String r4) {
        Integer r0 = 0;
        AppHost.Companion r1 = AppHost.a;     // Catch: Exception -> L9
        Integer r2 = (Integer) SettingsManager.obtainSettingsFast(r1.getApplication()).getAppSettings().get(r4);     // Catch: Exception -> L9
        j37.a.b(r1.getApplication()).e(r4);     // Catch: Exception -> L6
        return r2;
    L6:
        r0 = r2;
    L8:
        return r0;
    }

    @Override // com.larus.platform.api.m3
    public final String getSAMICoreAbStringConfig(String r4) {
        String r0 = XmlPullParser.NO_NAMESPACE;
        AppHost.Companion r1 = AppHost.a;     // Catch: Exception -> L5
        r0 = SettingsManager.obtainSettingsFast(r1.getApplication()).getAppSettings().get(r4).toString();     // Catch: Exception -> L5
        j37.a.b(r1.getApplication()).e(r4);     // Catch: Exception -> L5
        return r0;
    L8:
        return r0;
    }

    @Override // com.larus.platform.api.m3
    public final void i2(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        b.add(r2);
    }

    @Override // com.larus.platform.api.m3
    public final void k(String r3) {
        Intrinsics.checkNotNullParameter(r3, "page");
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L6;
        r0.k(r3);
        return;
    }

    @Override // com.larus.platform.api.m3
    public final void p3(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        b.remove(r2);
    }

    @Override // com.larus.platform.api.m3
    public final boolean y0(int r3) {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return !((List) l0.a(e10.I0(), new mq())).contains(Integer.valueOf(r3));
    }

    @Override // com.larus.platform.api.m3
    public final void e1(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        IBrowserService r0 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r0 == null) goto L6;
        r0.i(r3, r4, null);
        return;
    }
}
